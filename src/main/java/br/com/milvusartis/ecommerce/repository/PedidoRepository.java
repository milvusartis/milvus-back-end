package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByNumero(Long numero);
    List<Pedido> findByStatusPedido(StatusPedido statusPedido);
    List<Pedido> findByCliente(Optional<Cliente> cliente);
    List<Pedido> findByClienteAndStatus(Optional<Cliente> cliente, StatusPedido statusPedido);

}
