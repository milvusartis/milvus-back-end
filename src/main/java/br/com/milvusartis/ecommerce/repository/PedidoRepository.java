package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByNrPedido(Long nrPedido);
    List<Pedido> findByCliente(Cliente cliente);
    List<Pedido> findByDsStatusPedido(String dsStatusPedido);
    List<Pedido> findByClienteAndDsStatusPedido(Cliente cliente, String dsStatusPedido);

    //PedidoItem findByPedido(Pedido pedido);
}
