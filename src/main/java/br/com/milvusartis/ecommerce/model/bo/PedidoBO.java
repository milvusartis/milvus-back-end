package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.PedidoDTO;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoBO implements IBO<Pedido, PedidoDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PedidoDTO parseToDTO(Pedido pojo) {
        PedidoDTO pedidoDTO = modelMapper.map(pojo, PedidoDTO.class);
        return pedidoDTO;
    }

    @Override
    public Pedido parseToPOJO(PedidoDTO dto) {
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        return pedido;
    }

}