package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.Pedido;
import br.com.milvusartis.ecommerce.model.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoItemRepository  extends JpaRepository<PedidoItem, Long> {

}
