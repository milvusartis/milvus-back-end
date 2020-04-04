package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido pedido);

    void sendEmail(SimpleMailMessage msg);

}
