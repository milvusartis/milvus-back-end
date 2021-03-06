package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.dto.NotaFiscalDTO;
import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Empresa;
import br.com.milvusartis.ecommerce.model.entity.NotaFiscal;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.repository.EmpresaRepository;
import br.com.milvusartis.ecommerce.repository.NotaFiscalRepository;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class NotaFiscalService {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ContadorSequencialService contadorSequencialService;

    public NotaFiscal emitirNotaFiscal(Long idEmpresa, Long idCliente, Long idPedido) {

        Optional<Empresa> opt_empresa = empresaRepository.findById(idEmpresa);
        Empresa empresa = opt_empresa.orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));

        Optional<Cliente> opt_cliente = clienteRepository.findById(idCliente);
        Cliente cliente = opt_cliente.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));

        Optional<Pedido> opt_pedido = pedidoRepository.findById(idPedido);
        Pedido pedido = opt_pedido.orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado"));

        Integer contador = contadorSequencialService.numerarNotaFiscal();
        String contadorString = contador.toString();

        String uf = cliente.getEndereco().getUf();
        String naturezaOperacao;

        if(uf == "SP")
            naturezaOperacao = "5.102";
        else
            naturezaOperacao = "6.102";

        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setNumeroNf(contador);
        notaFiscal.setDataEmissao(LocalDate.now());
        notaFiscal.setNaturezaOperacao(naturezaOperacao);
        notaFiscal.setEmpresa(empresa);
        notaFiscal.setPedido(pedido);

        NotaFiscal notaFiscalEntity = notaFiscalRepository.save(notaFiscal);

        return notaFiscalEntity;

    }

}