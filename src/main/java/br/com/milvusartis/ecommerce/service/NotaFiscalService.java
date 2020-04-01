//package br.com.milvusartis.ecommerce.service;
//
//import br.com.milvusartis.ecommerce.model.dto.NotaFiscalDTO;
//import br.com.milvusartis.ecommerce.model.entity.NotaFiscal;
//import br.com.milvusartis.ecommerce.repository.NotaFiscalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//@Service("NotaFiscalService")
//public class NotaFiscalService {
//    @Autowired
//    NotaFiscalRepository notaFiscalRepository;
//
//
//    public ResponseEntity save(NotaFiscalDTO notaFiscalDTO){
//        NotaFiscal notaFiscalEntity = new NotaFiscal();
//
//        notaFiscalEntity.setDataEmissao(notaFiscalDTO.getDtNf());
//    //    notaFiscalEntity.setCliente(notaFiscalDTO.getCliente());
//        notaFiscalEntity.setEmpresa(notaFiscalDTO.getEmpresa());
//        notaFiscalEntity.setPedido(notaFiscalDTO.getPedido());
//        notaFiscalEntity.setNaturezaOperacao(notaFiscalDTO.getNaturezaOperacao());
//        notaFiscalEntity.setNumeroNf(notaFiscalDTO.getNfE());
//
//        NotaFiscal retornoNotaFiscal = notaFiscalRepository.save(notaFiscalEntity);
//        notaFiscalDTO.setIdNf(retornoNotaFiscal.getId());
//        return ResponseEntity.ok().body(notaFiscalDTO);
//    }
//
//    public void deleteById(Long id) {
//        notaFiscalRepository.deleteById(id);
//    }
//
//    public ResponseEntity alterar(NotaFiscal notaFiscal) {
//        NotaFiscal notaFiscalEntity = notaFiscalRepository.getOne(notaFiscal.getId());
//
//        notaFiscalEntity.setDataEmissao(notaFiscal.getDataEmissao());
//    //    notaFiscalEntity.setCliente(notaFiscal.getCliente());
//        notaFiscalEntity.setEmpresa(notaFiscal.getEmpresa());
//        notaFiscalEntity.setPedido(notaFiscal.getPedido());
//        notaFiscalEntity.setNaturezaOperacao(notaFiscal.getNaturezaOperacao());
//        notaFiscalEntity.setNumeroNf(notaFiscal.getNumeroNf());
//
//        return ResponseEntity.ok().body(notaFiscalRepository.save(notaFiscalEntity));
//    }
//}
