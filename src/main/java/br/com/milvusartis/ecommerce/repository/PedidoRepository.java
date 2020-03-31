package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByNumero(Long numero);
    List<Pedido> findByStatusPedido(String statusPedido);
//    List<Pedido> findByIdCliente(Long idCliente);
//    List<Pedido> findByIdClienteAndDsStatusPedido(Long idCliente, String dsStatusPedido);

}
