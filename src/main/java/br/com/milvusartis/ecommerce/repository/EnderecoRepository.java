package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long>{

}
