package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.dto.ContatoDTO;
import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.entity.Usuario;
import org.springframework.mail.SimpleMailMessage;

import javax.mail.internet.MimeMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendEmail(SimpleMailMessage msg);

    void sendOrderConfirmationHtmlEmail(Pedido pedido);

    void sendHtmlEmail(MimeMessage msg);

    void sendNewPasswordEmail(Usuario usuario, String newPass);

    void envioDeContato(ContatoDTO contato);


}
