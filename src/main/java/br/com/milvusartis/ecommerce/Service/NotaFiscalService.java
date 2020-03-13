package br.com.milvusartis.ecommerce.Service;

import br.com.milvusartis.ecommerce.model.DTO.EnderecoDTO;
import br.com.milvusartis.ecommerce.model.DTO.NotaFiscalDTO;
import br.com.milvusartis.ecommerce.model.Endereco;
import br.com.milvusartis.ecommerce.model.NotaFiscal;
import br.com.milvusartis.ecommerce.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("NotaFiscalService")
public class NotaFiscalService {
    @Autowired
    NotaFiscalRepository notaFiscalRepository;
    public ResponseEntity save(NotaFiscalDTO notaFiscalDTO){
        NotaFiscal notaFiscalEntity = new NotaFiscal();

        notaFiscalEntity.setData(notaFiscalDTO.getData());
        //notaFiscalEntity.setCliente(notaFiscalDTO.getCliente());
        notaFiscalEntity.setIdCliente(notaFiscalDTO.getIdCliente());
        notaFiscalEntity.setEmpresa(notaFiscalDTO.getEmpresa());
        //notaFiscalEntity.setPedido(notaFiscalDTO.getPedido());
        notaFiscalEntity.setIdPedido(notaFiscalDTO.getIdPedido());
        notaFiscalEntity.setNaturezaOperacao(notaFiscalDTO.getNaturezaOperacao());
        notaFiscalEntity.setNfe(notaFiscalDTO.getNfe());

        NotaFiscal retornoNotaFiscal = notaFiscalRepository.save(notaFiscalEntity);
        notaFiscalDTO.setIdNf(retornoNotaFiscal.getIdNf());
        return ResponseEntity.ok().body(notaFiscalDTO);
    }
}
