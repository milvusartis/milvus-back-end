package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PedidoService")
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido buscaPorId(Long idPedido) {
        return pedidoRepository.findById(idPedido).get();
    }

    public List<Pedido> buscarPedido(Long id, Long numero, String statusPedido) {

        List<Pedido> lista = new ArrayList<>();

        if (id == null && numero == null)
            lista = pedidoRepository.findAll();
        else if (id != null)
            lista.add(pedidoRepository.findById(id).get());
        else if (numero != null)
            lista = pedidoRepository.findByNumero(numero);
        else if (statusPedido != null)
            lista = pedidoRepository.findByStatusPedido(statusPedido);

        return lista;

    }

    public void excluirPorId(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido alterar(Pedido pedido) {

        Pedido pedidoEntity = pedidoRepository.getOne(pedido.getIdPedido());

        pedidoEntity.setNumero(pedido.getNumero());
        pedidoEntity.setDataPedido(pedido.getDataPedido());
        pedidoEntity.setValorFrete(pedido.getValorFrete());
        pedidoEntity.setValorTotal(pedido.getValorTotal());
        pedidoEntity.setStatusPedido(pedido.getStatusPedido());
        pedidoEntity.setDataEntrega(pedido.getDataEntrega());
        pedidoEntity.setPedidoItens(pedido.getPedidoItens());

        return pedidoRepository.save(pedidoEntity);

    }

    public Pedido alterarCamposEspecificos(Pedido pedido) {
        return this.alterar(pedido);
    }

}