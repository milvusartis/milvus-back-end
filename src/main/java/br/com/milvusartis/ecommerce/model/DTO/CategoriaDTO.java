package br.com.milvusartis.ecommerce.model.DTO;

import br.com.milvusartis.ecommerce.model.Categoria;
import br.com.milvusartis.ecommerce.model.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO {

    private Long codigo;
    private String descricao;


    public Categoria transformaParaCategoria(){
        return new Categoria(codigo, descricao);
    }

    public static CategoriaDTO transformaEmDTO(Categoria categoria){
        return new CategoriaDTO(categoria.getId(), categoria.getDescricao());
    }

}
