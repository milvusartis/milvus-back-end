package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.*;
import br.com.milvusartis.ecommerce.model.tipos.Regra;
import br.com.milvusartis.ecommerce.model.tipos.StatusPagamento;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import br.com.milvusartis.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public void intantiateTestDatabase(){

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        //EMPRESA com ENDEREÇO:

            Endereco end1 = new Endereco(null, "Rua da Milvus", 1, null, "Vila da Pipa", "Pipópolis", "SP", "000000000");
                Empresa emp1 = new Empresa(1L,"Milvus Artis", "00.000.000/0000-00", "000.000.000.000", end1);

            empresaRepository.save(emp1);

        //CLIENTE e USUARIO com ENDEREÇO:

            Endereco end2 = new Endereco(null, "Rua Eugênia de Carvalho", 525, "Casa A", "Vila Matilde", "São Paulo", "SP", "03516000");
                Usuario usu1 = new Usuario(null, "Diógenes Bezerra Pereira", "ads.diogenes@gmail.com",  encoder.encode("123456"), Regra.ROLE_ADMIN);
                    Cliente cli1 = new Cliente(null, "04205595310", "2003034096537", "11964367824", usu1, end2);

                Usuario usu2 = new Usuario(null, "Alvaro dos Santos Saraiva", "trusteco@hotmail.com", encoder.encode("123456"), Regra.ROLE_USER);
                    Cliente cli2 = new Cliente(null, "07381194821", "157278293", "11932145053", usu2, end2);

            Endereco end3 = new Endereco(null, "Rua Abadia", 251, "Casa 1", "Nossa Senhora da Abadia", "Uberaba", "MG", "38025-450");
                Usuario usu3 = new Usuario(null, "Isabela Zeitune Dezan", "isabelazeitunedezan@gmail.com", encoder.encode("123456"), Regra.ROLE_ADMIN);
                    Cliente cli3 = new Cliente(null, "40692679804", "484223859", "11948383433", usu3, end3);

        clienteRepository.saveAll(Arrays.asList( cli1, cli2, cli3));

        //USUÁRIO:

            Usuario u0 = new Usuario(null, "Administrador do Sistema", "admin@admin.com", encoder.encode("admin"), Regra.ROLE_ADMIN);

        usuarioRepository.saveAll(Arrays.asList(u0));

        //CATEGORIA:

            Categoria cat1 = new Categoria(null, "Pipa");

            Categoria cat2 = new Categoria(null, "Linha");

            Categoria cat3 = new Categoria(null, "Lata");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        //PRODUTO:

//            Produto pro1 = new Produto(null, "Pipa Grande Colorida", "Pipa colorida", "https://i.ibb.co/SvxNRNy/pipa-box.png", 40.5, Boolean.TRUE, cat1, new Estoque(null, 5, 0));
//
//            Produto pro2 = new Produto(null, "Pipa Media Colorida", "Pipa Beneficente", "https://i.ibb.co/rsvK81S/pipa-flex.png", 45.5, Boolean.TRUE, cat1, new Estoque(null, 10, 1));
//
//            Produto pro3 = new Produto(null, "Pipa Capucheta", "Pipa estilizada", "https://i.ibb.co/xsGBZVK/pipa-neon.png", 50.0, Boolean.TRUE, cat1, new Estoque(null, 20, 0));
//
//            Produto pro4 = new Produto(null, "Pipa Rocket", "Pipa descolada", "https://i.ibb.co/Db0Z0SM/pipa-rocket.png", 43.75, Boolean.FALSE, cat1, new Estoque(null, 0, 0));
//
//            Produto pro5 = new Produto(null, "Linha colorida", "Linha colorida", "https://i.ibb.co/C2gh325/linhacolorida.png", 10.0, Boolean.TRUE, cat2, new Estoque(null, 8, 4));
//
//            Produto pro6 = new Produto(null, "Linha amarela", "Linha amarela", "https://i.ibb.co/3Y906L3/linha10.png", 9.0, Boolean.FALSE, cat2, new Estoque(null, 0, 0));
//
//            Produto pro7 = new Produto(null, "Carretilha verde com linha", "Carretilha com linha", "https://i.ibb.co/h1GkxYP/carretilhacomlinha.png", 20.0, Boolean.FALSE, cat3, new Estoque(null, 0, 0));
//
//            Produto pro8 = new Produto(null, "Mini carretilha amarela", "Mini carretilha", "https://i.ibb.co/QjgpzmJ/minicarretilha.png", 18.0, Boolean.FALSE, cat3, new Estoque(null, 0, 0));

        Produto pro1 = new Produto(null, "Pipa Grande Colorida", "Pipa colorida", "https://i.ibb.co/SvxNRNy/pipa-box.png", 40.5, Boolean.TRUE, cat1);

        Produto pro2 = new Produto(null, "Pipa Media Colorida", "Pipa Beneficente", "https://i.ibb.co/rsvK81S/pipa-flex.png", 45.5, Boolean.TRUE, cat1);

        Produto pro3 = new Produto(null, "Pipa Capucheta", "Pipa estilizada", "https://i.ibb.co/xsGBZVK/pipa-neon.png", 50.0, Boolean.TRUE, cat1);

        Produto pro4 = new Produto(null, "Pipa Rocket", "Pipa descolada", "https://i.ibb.co/Db0Z0SM/pipa-rocket.png", 43.75, Boolean.FALSE, cat1);

        Produto pro5 = new Produto(null, "Linha colorida", "Linha colorida", "https://i.ibb.co/C2gh325/linhacolorida.png", 10.0, Boolean.TRUE, cat2);

        Produto pro6 = new Produto(null, "Linha amarela", "Linha amarela", "https://i.ibb.co/3Y906L3/linha10.png", 9.0, Boolean.FALSE, cat2);

        Produto pro7 = new Produto(null, "Carretilha verde com linha", "Carretilha com linha", "https://i.ibb.co/h1GkxYP/carretilhacomlinha.png", 20.0, Boolean.FALSE, cat3);

        Produto pro8 = new Produto(null, "Mini carretilha amarela", "Mini carretilha", "https://i.ibb.co/QjgpzmJ/minicarretilha.png", 18.0, Boolean.FALSE, cat3);


        produtoRepository.saveAll(Arrays.asList(pro1, pro2, pro3, pro4, pro5, pro6, pro7, pro8));

//        PEDIDO com PEDIDO ITEM e PAGAMENTO:

            PedidoItem pedIte1 = new PedidoItem(null, 2, 40.5, pro1);
            PedidoItem pedIte2 = new PedidoItem(null, 3, 45.5, pro2);
                Pagamento pag1 = new Pagamento(null, "Diógenes Bezerra Pereira", "11964367824", "04205595310", "Cartão Master", StatusPagamento.PAGAMENTO_APROVADO);
                    Pedido pd1 = new Pedido(null, 1, LocalDate.now(), 4.00, 221.5, StatusPedido.PEDIDO_ENVIADO, LocalDate.now().plusDays(5), 5, Arrays.asList(pedIte1, pedIte2), cli1, pag1);

            PedidoItem pedIte3 = new PedidoItem(null, 1, 50.0, pro3);
            PedidoItem pedIte4 = new PedidoItem(null, 3, 10.0, pro4);
                Pagamento pag2 = new Pagamento(null, "Alvaro dos Santos Saraiva", "11932145053", "07381194821", "Cartão Visa", StatusPagamento.PAGAMENTO_APROVADO);
                    Pedido pd2 = new Pedido(null, 2, LocalDate.now(), 6.00, 86.0, StatusPedido.PAGAMENTO_CONFIRMADO, LocalDate.now().plusDays(5), 5, Arrays.asList(pedIte3, pedIte4), cli2, pag2);

        pedidoRepository.saveAll(Arrays.asList(pd1, pd2));

    }
}
