package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.exception.MailNotSendException;
import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.PagamentoBO;
import br.com.milvusartis.ecommerce.model.bo.PedidoBO;
import br.com.milvusartis.ecommerce.model.bo.UsuarioBO;
import br.com.milvusartis.ecommerce.model.dto.PedidoRequestDTO;
import br.com.milvusartis.ecommerce.model.entity.*;
import br.com.milvusartis.ecommerce.model.pojo.Cartao;
import br.com.milvusartis.ecommerce.model.tipos.StatusPagamento;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import br.com.milvusartis.ecommerce.repository.ProdutoRepository;
import br.com.milvusartis.ecommerce.service.gatway.PagamentoGatwayService;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service("PedidoService")

public class PedidoService {


    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    CheckoutService checkoutService;

    @Autowired
    PagamentoGatwayService pagamentoGatwayService;

    @Autowired
    PedidoBO pedidoBO;

    @Autowired
    UsuarioBO usuarioBO;

    @Autowired
    PagamentoBO pagamentoBO;

    @Autowired
    NotaFiscalService notaFiscalService;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ContadorSequencialService contadorSequencialService;


    public Pedido inicializaPedido(PedidoRequestDTO pedidoRequestDTO) {

        Pedido pedido = pedidoBO.parseToPOJO(pedidoRequestDTO.getPedido());
        Cliente cliente = checkoutService.findClienteFromIdUsuario(usuarioBO.parseToPOJO(pedidoRequestDTO.getUsuario()).getIdUsuario());

        Integer contador = contadorSequencialService.numerarNotaFiscal();
// TODO consertar numero do pedido para utilizar o contador
//        pedido.setNumero(contador);
        pedido.setCliente(cliente);
        pedido.setDataPedido(LocalDate.now());
//        Cliente cliente = clienteRepository.findById(pedido.getCliente().getIdCliente()).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
//        pedido.setCliente(cliente);
        for (PedidoItem pi : pedido.getPedidoItens()) {
            Produto produto = produtoRepository.findById(pi.getProduto().getIdProduto()).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado"));
            pi.setProduto(produto);
        }
        pedido.setValorTotal(pedido.getSubtotal() + pedido.getValorFrete());
        pedido.setStatusPedido(StatusPedido.PEDIDO_REALIZADO);

        pedido.setPagamento(pagamentoBO.parseToPOJO(pedidoRequestDTO.getPagamento()));
        pedido.getPagamento().setStatusPagamento(StatusPagamento.AGUARDANDO_PAGAMENTO);
        return pedido;
    }


    public void enviaEmailAprovacao(Pedido pedido) {
        try {
            emailService.sendOrderConfirmationHtmlEmail(pedido);
        } catch (Exception ex) {
            throw new MailNotSendException(pedido.toString());
        }
    }

    public void confirmaPagamento(Pedido pedido, Cartao cartao) {
        if (pagamentoGatwayService.enviarPagamentoParaConfirmacao(pedido.getPagamento(), cartao)) {
            pedido.getPagamento().setStatusPagamento(StatusPagamento.PAGAMENTO_APROVADO);
            pedido.setStatusPedido(StatusPedido.PAGAMENTO_CONFIRMADO);
            pedidoRepository.save(pedido);
            emailService.sendOrderConfirmationHtmlEmail(pedido);
        } else {
            pedido.getPagamento().setStatusPagamento(StatusPagamento.PAGAMENTO_REPROVADO);
        }
    }

    public Pedido aprovarPedido(Pedido pedido) {
        pedido.setDataEntrega(pedido.getDataPedido().plusDays(pedido.getDiasParaEntrega()));
        pedido.setStatusPedido(StatusPedido.PEDIDO_ENVIADO);

        Cliente cliente = pedido.getCliente();
        Long idCliente = cliente.getIdCliente();

        Long idPedido = pedido.getIdPedido();

        notaFiscalService.emitirNotaFiscal(1L, idCliente, idPedido);

        //TODO Atualizar o Estoque
        return pedido;
    }

    public Pedido entregarPedido(Pedido pedido) {
        pedido.setStatusPedido(StatusPedido.PEDIDO_ENTREGUE);
        return pedido;
    }


}