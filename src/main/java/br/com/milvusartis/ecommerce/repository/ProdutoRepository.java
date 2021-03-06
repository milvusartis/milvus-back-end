package br.com.milvusartis.ecommerce.repository;

import br.com.milvusartis.ecommerce.model.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNome(String nome);
    List<Produto> findByIsAtivo(Boolean isAtivo);

    @Query("select p from Produto p")
    Page<Produto> findAllPage(Pageable pageable);
}

//@Repository
//public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
//
//    @Query("select c from Cliente c")
//    Page<Cliente> findAllPage(Pageable pageable);
//
//    @Query("select c from Cliente c")
//    Slice<Cliente> findAllSlice(Pageable pageable);
//
//    @Query("select c from Cliente c")
//    List<Cliente> findAllSorted(Sort sort);
//
//}