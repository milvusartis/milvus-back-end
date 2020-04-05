//USADO PARA TESTAR A CRIAÇÃO DE NOTA FISCAL

//package br.com.milvusartis.ecommerce.controller;
//
//import br.com.milvusartis.ecommerce.model.bo.PagamentoBO;
//import br.com.milvusartis.ecommerce.model.dto.PagamentoDTO;
//import br.com.milvusartis.ecommerce.model.entity.Pagamento;
//import br.com.milvusartis.ecommerce.repository.PagamentoRepository;
//import br.com.milvusartis.ecommerce.service.NotaFiscalService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class PagamentoController {
//
//    @Autowired
//    PagamentoRepository pagamentoRepository;
//
//    @Autowired
//    PagamentoBO pagamentoBO;
//
//    @Autowired
//    NotaFiscalService notaFiscalService;
//
//    @PostMapping("/pagamentos")
//    public ResponseEntity<?> cadastrar(@RequestBody PagamentoDTO pagamentoDTO) {
//
//        if (pagamentoDTO == null) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento não pode estar vazio");
//        }
//
//        Pagamento pagamento = pagamentoBO.parseToPOJO(pagamentoDTO);
//        Pagamento pagamentoEntity = pagamentoRepository.save(pagamento);
//
//        Long idPedido = 8L;
//        Long idCliente = 1L;
//
//        notaFiscalService.emitirNotaFiscal(1L, idCliente, idPedido);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoBO.parseToDTO(pagamentoEntity));
//
//    }
//
//}/