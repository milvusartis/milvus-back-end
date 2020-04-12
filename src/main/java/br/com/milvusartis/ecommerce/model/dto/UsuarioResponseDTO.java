package br.com.milvusartis.ecommerce.model.dto;

import br.com.milvusartis.ecommerce.model.tipos.Perfil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    private Long idUsuario;
    private String nome;
    private String email;
    private Set<Integer> perfis;

    public Set <Perfil> getPerfis(){
        return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

}
