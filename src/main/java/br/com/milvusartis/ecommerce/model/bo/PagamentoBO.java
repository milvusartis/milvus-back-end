package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.PagamentoDTO;
import br.com.milvusartis.ecommerce.model.entity.Pagamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class PagamentoBO implements IBO<Pagamento, PagamentoDTO>  {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PagamentoDTO parseToDTO(Pagamento pojo) {
        PagamentoDTO pagamentoDTO = modelMapper.map(pojo, PagamentoDTO.class);
        return pagamentoDTO;
    }

    @Override
    public Pagamento parseToPOJO(PagamentoDTO dto) {
        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        return pagamento;
    }

}
