package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.pojo.Cartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {
    PedidoDTO pedido;
    UsuarioDTO usuario;
    PagamentoDTO pagamento;
    Cartao cartao;
    String nomeEntrega;
    EnderecoDTO enderecoEntrega;

}
