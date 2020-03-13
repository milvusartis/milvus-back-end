package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByNrPedido(Integer nrPedido);
    List<Pedido> findByIdPedidoAndNrPedido(Long idPedido, Integer nrPedido);
}
