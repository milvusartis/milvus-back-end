package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Cliente;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("ClienteService")
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente buscaPorId(Long idCliente) {
        return clienteRepository.findById(idCliente).get();
    }

    public List<Cliente> buscarCliente(Long id, String cpf) {

        List<Cliente> lista = new ArrayList<>();

        if (id == null && cpf == null)
            lista = clienteRepository.findAll();
        else if (id != null)
            lista.add(clienteRepository.findById(id).get());
        else if (cpf != null)
            lista = clienteRepository.findByCpf(cpf);

        return lista;

    }

    public void excluirPorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente alterar(Cliente cliente) {

        Cliente clienteEntity = clienteRepository.getOne(cliente.getIdCliente());

        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setRg(cliente.getRg());
        clienteEntity.setTelefone(cliente.getTelefone());
        clienteEntity.setUsuario(cliente.getUsuario());
        clienteEntity.setEndereco(cliente.getEndereco());

        return clienteRepository.save(clienteEntity);

    }

    public Cliente alterarCamposEspecificos(Cliente cliente) {
        return this.alterar(cliente);
    }

}
