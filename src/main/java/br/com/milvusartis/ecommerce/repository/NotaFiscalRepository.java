package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal,Long>{
}
