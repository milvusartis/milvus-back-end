package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.PedidoResponseDTO;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoResponseBO implements IBO<Pedido, PedidoResponseDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PedidoResponseDTO parseToDTO(Pedido pojo) {
        PedidoResponseDTO pedidoResponseDTO = modelMapper.map(pojo, PedidoResponseDTO.class);
        return pedidoResponseDTO;
    }

    @Override
    public Pedido parseToPOJO(PedidoResponseDTO dto) {
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        return pedido;
    }

}