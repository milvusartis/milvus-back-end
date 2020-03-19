package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoItemRepository  extends JpaRepository<PedidoItem, Long> {

}
