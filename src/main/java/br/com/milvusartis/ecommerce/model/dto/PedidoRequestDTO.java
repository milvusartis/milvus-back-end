package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoRequestDTO {
    PedidoDTO pedido;
    UsuarioDTO usuario;
    PagamentoDTO pagamento;
    CartaoDTO cartao;
    String nomeEntrega;
    EnderecoDTO enderecoEntrega;

}
