package br.com.milvusartis.ecommerce.controller;

import br.com.milvusartis.ecommerce.exception.ResourceNotFoundException;
import br.com.milvusartis.ecommerce.model.bo.EmpresaBO;
import br.com.milvusartis.ecommerce.model.dto.EmpresaDTO;
import br.com.milvusartis.ecommerce.model.entity.Empresa;
import br.com.milvusartis.ecommerce.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    EmpresaBO empresaBO;

    @PostMapping("/empresas")
    public ResponseEntity<?> cadastrar(@RequestBody EmpresaDTO empresaDTO) {

        if (empresaDTO == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não pode estar vazia");
        }

        Empresa empresaEntity = empresaRepository.save(empresaBO.parseToPOJO(empresaDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaBO.parseToDTO(empresaEntity));

    }

    @GetMapping("/empresas")
    public ResponseEntity<?> listar() {

        List<Empresa> listaEmpresas = empresaRepository.findAll();
        List<EmpresaDTO> listaDeEmpresasResposta = new ArrayList<>();

        listaEmpresas.forEach((empresa) -> {
            listaDeEmpresasResposta.add(empresaBO.parseToDTO(empresa));
        });

        return ResponseEntity.status(HttpStatus.OK).body(listaDeEmpresasResposta);

    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<?> mostrar(@PathVariable("id") Long id) {

        Optional<Empresa> opt_empresa = empresaRepository.findById(id);
        Empresa empresa = opt_empresa.orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));

        return ResponseEntity.status(HttpStatus.OK).body(empresaBO.parseToDTO(empresa));

    }

    @DeleteMapping("/empresas/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") Long id) {

        return empresaRepository.findById(id)
                .map(empresa -> {
                    empresaRepository.delete(empresa);
                    return ResponseEntity.status(HttpStatus.OK).body("Empresa excluída");

                }).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

}