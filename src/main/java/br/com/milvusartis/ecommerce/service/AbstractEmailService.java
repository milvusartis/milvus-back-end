package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.model.entity.Pedido;
import br.com.milvusartis.ecommerce.model.tipos.StatusPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendOrderConfirmationEmail(Pedido pedido) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromPedido(pedido);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido pedido) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(pedido.getCliente().getUsuario().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Acompanhamento de Pedido! Código: " + pedido.getIdPedido());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(pedido.toString());
        return sm;
    }

    protected String htmlFromTemplatePedido(Pedido pedido) {
        Context context = new Context();
        context.setVariable("pedido", pedido);
        return switchTemplateHtml(pedido.getStatusPedido(), context);

    }

    private String switchTemplateHtml(StatusPedido statusPedido,  Context context){

        switch (statusPedido) {
            case PEDIDO_REALIZADO:
                return templateEngine.process("email/pedidoRealizado", context);

            case PAGAMENTO_CONFIRMADO:
                return templateEngine.process("email/pagamentoConfirmado", context);

            case PEDIDO_ENVIADO:
                return templateEngine.process("email/pedidoEnviado", context);

            case PEDIDO_ENTREGUE:
                return templateEngine.process("email/pedidoEntregue", context);

            default:
                return templateEngine.process("email/solicitacaoNaoConcluida", context);

        }
    }

    @Override
    public void sendOrderConfirmationHtmlEmail(Pedido pedido) {
        try {
            MimeMessage mm = prepareMimeMessageFromPedido(pedido);
            sendHtmlEmail(mm);
        } catch (MessagingException ex) {
            sendOrderConfirmationEmail(pedido);
        }

    }

    protected MimeMessage prepareMimeMessageFromPedido(Pedido pedido) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
        mmh.setTo(pedido.getCliente().getUsuario().getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("Acompanhamento de Pedido! Código: " + pedido.getIdPedido());
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTemplatePedido(pedido), true);
        return mimeMessage;
    }
}


