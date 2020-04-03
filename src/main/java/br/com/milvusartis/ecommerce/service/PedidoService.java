package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Estoque;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.entity.Produto;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PedidoService")
public class PedidoService {



    public Pedido inicializaPedido(Pedido pedido){
        //TODO inicializar pedido
        return pedido;
    }

}