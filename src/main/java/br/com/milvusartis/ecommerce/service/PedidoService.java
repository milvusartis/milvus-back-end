package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Service("PedidoService")

public class PedidoService {



    public Pedido inicializaPedido(Pedido pedido){
        //TODO inicializar pedido
//        pedido.setDataPedido(new Date());
        pedido.setDataPedido(LocalDate.now());
        pedido.setValorTotal(pedido.calculaSubtotalValorTotalDosItensDePedido()+pedido.getValorFrete());
        pedido.setStatusPedido(StatusPedido.PEDIDO_REALIZADO);


        pedido.setDataEntrega(pedido.getDataPedido().plusDays(5));

//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//		System.out.println(sdf.format(new Date()));



        return pedido;
    }

}