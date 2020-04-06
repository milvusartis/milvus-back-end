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

        Categoria cat1 = new Categoria(null, "Pipa");
        Categoria cat2 = new Categoria(null, "Linha");
        Categoria cat3 = new Categoria(null, "Lata");


        Produto p1 = new Produto(null, "Pipa Grande Colorida", "Pipa colorida", "https://i.ibb.co/SvxNRNy/pipa-box.png", 40.5, Boolean.TRUE, cat1, new Estoque(null, 5, 0));
        Produto p2 = new Produto(null, "Pipa Media Colorida", "Pipa Beneficente", "https://i.ibb.co/rsvK81S/pipa-flex.png", 45.5, Boolean.TRUE, cat1, new Estoque(null, 10, 1));
        Produto p3 = new Produto(null, "Pipa Capucheta", "Pipa estilizada", "https://i.ibb.co/xsGBZVK/pipa-neon.png", 50.0, Boolean.TRUE, cat1, new Estoque(null, 20, 0));
        Produto p4 = new Produto(null, "Linha colorida", "Linha colorida", "https://i.ibb.co/C2gh325/linhacolorida.png", 10.0, Boolean.TRUE, cat2, new Estoque(null, 8, 4));
        Produto p5 = new Produto(null, "Carretilha com linha", "Carretilha", "https://i.ibb.co/h1GkxYP/carretilhacomlinha.png", 20.0, Boolean.FALSE, cat3, new Estoque(null, 0, 0));

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        Usuario u0 = new Usuario(null, "Administrador do Sistema", "admin", encoder.encode("admin"), Regra.ROLE_ADMIN);

        usuarioRepository.saveAll(Arrays.asList(u0));


        Endereco e1 = new Endereco(null, "Rua Eugênia de Carvalho", 525, "Casa A", "Vila Matilde", "São Paulo", "SP", "03516000");
        Usuario u1 = new Usuario(null, "Diógenes Bezerra Pereira", "ads.diogenes@gmail.com",  encoder.encode("123456"), Regra.ROLE_ADMIN);
        Cliente c1 = new Cliente(null, "04205595310", "2003034096537", "11964367824", u1, e1);

        Usuario u2 = new Usuario(null, "Alvaro dos Santos Saraiva", "trusteco@hotmail.com", encoder.encode("123456"), Regra.ROLE_USER);
        Cliente c2 = new Cliente(null, "07381194821", "157278293", "11932145053", u2, e1);

        clienteRepository.saveAll(Arrays.asList(c1,c2));


        PedidoItem pi1 = new PedidoItem(null, 2, 40.5, p1);
        PedidoItem pi2 = new PedidoItem(null, 3, 45.5, p2);

        PedidoItem pi4 = new PedidoItem(null, 1, 50.0, p3);
        PedidoItem pi5 = new PedidoItem(null, 3, 10.0, p4);

        Pagamento pg1 = new Pagamento(null, "Diógenes Bezerra Pereira", "11964367824", "04205595310", "Cartão Master", StatusPagamento.PAGAMENTO_APROVADO);
        Pagamento pg2 = new Pagamento(null, "Alvaro dos Santos Saraiva", "11932145053", "07381194821", "Cartão Visa", StatusPagamento.PAGAMENTO_APROVADO);

        Pedido pd1 = new Pedido(null, null, LocalDate.now(), 4.00, 221.5, StatusPedido.PEDIDO_ENVIADO, LocalDate.now().plusDays(5), 5, Arrays.asList(pi1, pi2), c1, pg1);
        Pedido pd2 = new Pedido(null, null, LocalDate.now(), 6.00, 86.0, StatusPedido.PAGAMENTO_CONFIRMADO, LocalDate.now().plusDays(5), 5, Arrays.asList(pi4, pi5), c2, pg2);


        pedidoRepository.saveAll(Arrays.asList(pd1,pd2));

        Empresa emp1 = new Empresa(1L,"Milvus Artis", "61.585.865/0240-93", "116.756.280.113", e1);
        empresaRepository.save(emp1);

    }
}
