package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    //List<Cliente> findByIdAnd();
}
