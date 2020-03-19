package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.dto.EnderecoDTO;
import br.com.milvusartis.ecommerce.model.entity.Endereco;
import br.com.milvusartis.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("EnderecoService")
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;
    public ResponseEntity save(EnderecoDTO enderecoDTO){
        Endereco enderecoEntity = new Endereco();

        enderecoEntity.setCep(enderecoDTO.getCep());
        enderecoEntity.setRua(enderecoDTO.getRua());
        enderecoEntity.setNumero(enderecoDTO.getNumero());
        enderecoEntity.setComplemento(enderecoDTO.getComplemento());
        enderecoEntity.setBairro(enderecoDTO.getBairro());
        enderecoEntity.setCidade(enderecoDTO.getCidade());
        enderecoEntity.setEstado(enderecoDTO.getEstado());

        Endereco retornoEndereco = enderecoRepository.save(enderecoEntity);
        enderecoDTO.setIdEndereco(retornoEndereco.getIdEndereco());
        return ResponseEntity.ok().body(enderecoDTO);
    }
    public void deleteById(Long id) {
        enderecoRepository.deleteById(id);
    }

    public ResponseEntity alterar(Endereco endereco) {
       Endereco enderecoEntity = enderecoRepository.getOne(endereco.getIdEndereco());

        enderecoEntity.setCep(endereco.getCep());
        enderecoEntity.setRua(endereco.getRua());
        enderecoEntity.setNumero(endereco.getNumero());
        enderecoEntity.setComplemento(endereco.getComplemento());
        enderecoEntity.setBairro(endereco.getBairro());
        enderecoEntity.setCidade(endereco.getCidade());
        enderecoEntity.setEstado(endereco.getEstado());

       return ResponseEntity.ok().body(enderecoRepository.save(enderecoEntity));
    }
}
