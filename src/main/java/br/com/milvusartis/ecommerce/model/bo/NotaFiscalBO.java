package br.com.milvusartis.ecommerce.model.bo;

import br.com.milvusartis.ecommerce.model.dto.NotaFiscalDTO;
import br.com.milvusartis.ecommerce.model.entity.NotaFiscal;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotaFiscalBO implements IBO<NotaFiscal, NotaFiscalDTO> {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public NotaFiscalDTO parseToDTO(NotaFiscal pojo) {
        NotaFiscalDTO notaFiscalDTO = modelMapper.map(pojo, NotaFiscalDTO.class);
        return notaFiscalDTO;
    }

    @Override
    public NotaFiscal parseToPOJO(NotaFiscalDTO dto) {
        NotaFiscal notaFiscal = modelMapper.map(dto, NotaFiscal.class);
        return notaFiscal;
    }

}