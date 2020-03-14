package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.Estoque;
import br.com.milvusartis.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    public Estoque findByProduto(Produto produto);
}
