package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.PedidoItemDTO;
import br.com.milvusartis.ecommerce.model.entity.PedidoItem;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoItemBO implements IBO<PedidoItem, PedidoItemDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PedidoItemDTO parseToDTO(PedidoItem pojo) {
        PedidoItemDTO pedidoItemDTO = modelMapper.map(pojo, PedidoItemDTO.class);
        return pedidoItemDTO;
    }

    @Override
    public PedidoItem parseToPOJO(PedidoItemDTO dto) {
        PedidoItem pedidoItem = modelMapper.map(dto, PedidoItem.class);
        return pedidoItem;
    }

}