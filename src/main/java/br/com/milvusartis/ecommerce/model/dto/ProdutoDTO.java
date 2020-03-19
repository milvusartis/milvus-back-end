package br.com.milvusartis.ecommerce.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long idProduto;
    private String nome;
    private String descricao;
    private String imagem;
    private Double valorUnitario;
    private Boolean disponibilidade;
    private CategoriaDTO categoria;

    /*Ótima opção quando é necessário proteger alguns dados da entidade

     Quando desejar mostrar um atributo apenas da entidade, utilize o padrão camel case, iniciando com o nome da entidade, seguido do nome do atributo*/

    //private Long estoqueIdEstoque;

    /* Também pode-se utilizar o nome do atributo desde que as duas entidades não possuam o memso nome*/
    private Long idEstoque;

    /*Quando desejar mostrar todos os atributos do objeto*/
    //private EstoqueDTO estoque;

}
