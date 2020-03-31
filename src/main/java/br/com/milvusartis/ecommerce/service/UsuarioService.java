package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Usuario;
import br.com.milvusartis.ecommerce.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("UsuarioService")
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscaPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

    public List<Usuario> buscarUsuario(Long id, String email) {

        List<Usuario> lista = new ArrayList<>();

        if (id == null && email == null)
            lista = usuarioRepository.findAll();
        else if (id != null)
            lista.add(usuarioRepository.findById(id).get());
        else if (email != null)
            lista = usuarioRepository.findByEmail(email);

        return lista;

    }

    public void excluirPorId(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario alterar(Usuario usuario) {

        Usuario usuarioEntity = usuarioRepository.getOne(usuario.getIdUsuario());

        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setSenha(usuario.getSenha());

        return usuarioRepository.save(usuarioEntity);

    }

    public Usuario alterarCamposEspecificos(Usuario usuario) {
        return this.alterar(usuario);
    }

}