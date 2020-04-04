package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.*;
import br.com.milvusartis.ecommerce.repository.CategoriaRepository;
import br.com.milvusartis.ecommerce.repository.ClienteRepository;
import br.com.milvusartis.ecommerce.repository.PedidoRepository;
import br.com.milvusartis.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    PedidoRepository pedidoRepository;


    public void intantiateTestDatabase(){

        Categoria cat1 = new Categoria(null, "Pipa");
        Categoria cat2 = new Categoria(null, "Linha");
        Categoria cat3 = new Categoria(null, "Lata");


        Produto p1 = new Produto(null, "Pipa Grande Colorida", "Pipa colorida", "https://i.ibb.co/SvxNRNy/pipa-box.png", 40.5, null, cat1, null);
        Produto p2 = new Produto(null, "Pipa Media Colorida", "Pipa Beneficente", "https://i.ibb.co/rsvK81S/pipa-flex.png", 45.5, null, cat1, null);
        Produto p3 = new Produto(null, "Pipa Capucheta", "Pipa estilizada", "https://i.ibb.co/xsGBZVK/pipa-neon.png", 50.0, null, cat1, null);
        Produto p4 = new Produto(null, "Linha colorida", "Linha colorida", "https://i.ibb.co/C2gh325/linhacolorida.png", 10.0, null, cat1, null);
        Produto p5 = new Produto(null, "Carretilha com linha", "Carretilha", "https://i.ibb.co/h1GkxYP/carretilhacomlinha.png", 20.0, null, cat1, null);

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        Endereco e1 = new Endereco(null, "Rua Eugênia de Carvalho", 525, "casa a", "vila matilde", "São Paulo", "SP", "03516000");
        Usuario u1 = new Usuario(null, "Diógenes Bezerra Pereira", "ads.diogenes@gmail.com", "123456", null);
        Cliente c1 = new Cliente(null, "04205595310", "2003034096537", "11964367824", u1, e1);

        clienteRepository.saveAll(Arrays.asList(c1));


        PedidoItem pi1 = new PedidoItem(null, 2, 40.5, p1);
        PedidoItem pi2 = new PedidoItem(null, 3, 45.5, p2);

        PedidoItem pi4 = new PedidoItem(null, 1, 50.0, p3);
        PedidoItem pi5 = new PedidoItem(null, 3, 10.0, p4);

        Pedido pd1 = new Pedido(null, null, null, 4.00, null, null, null, 5, Arrays.asList(pi1, pi2), c1, null);
//        Pedido pd2 = new Pedido(null, null, null, 6.00, null, null, null, 5, Arrays.asList(pi4, pi5), c1, null);


        pedidoRepository.saveAll(Arrays.asList(pd1));

    }
}
