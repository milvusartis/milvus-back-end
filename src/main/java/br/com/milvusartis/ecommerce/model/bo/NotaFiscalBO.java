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
        String contador = notaFiscalDTO.getNumeroNf();

        while(contador.length() < 9)
        contador = "0".concat(contador);

        notaFiscalDTO.setNumeroNf(contador);
        return notaFiscalDTO;
    }

    @Override
    public NotaFiscal parseToPOJO(NotaFiscalDTO dto) {
        NotaFiscal notaFiscal = modelMapper.map(dto, NotaFiscal.class);
        return notaFiscal;
    }

}