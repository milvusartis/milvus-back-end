package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatusPedido(StatusPedido statusPedido);
    List<Pedido> findByCliente(Cliente cliente);
    List<Pedido> findByClienteAndStatusPedido(Cliente cliente, StatusPedido statusPedido);

}
