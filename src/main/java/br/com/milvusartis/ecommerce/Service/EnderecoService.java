package br.com.milvusartis.ecommerce.Service;

import br.com.milvusartis.ecommerce.model.DTO.EnderecoDTO;
import br.com.milvusartis.ecommerce.model.Endereco;
import br.com.milvusartis.ecommerce.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
