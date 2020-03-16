package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.Cliente;
import br.com.milvusartis.ecommerce.model.Pedido;
import br.com.milvusartis.ecommerce.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByNrPedido(Long nrPedido);
    List<Pedido> findByDsStatusPedido(String dsStatusPedido);
    List<Pedido> findByCliente(Cliente cliente);
    List<Pedido> findByClienteAndDsStatusPedido(Cliente cliente, String dsStatusPedido);

//    List<Pedido> findByIdCliente(Long idCliente);
//    List<Pedido> findByIdClienteAndDsStatusPedido(Long idCliente, String dsStatusPedido);
    //PedidoItem findByPedido(Pedido pedido);
}
