package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Long>{
}
