package br.com.milvusartis.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

public class SmtpEmailService extends AbstractEmailService{

    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

    @Autowired
    MailSender mailSender;

    @Autowired
    JavaMailSender javaMailSender;



    @Override
    public void sendEmail(SimpleMailMessage msg) {
        LOG.info("Enviando Email...");
        mailSender.send(msg);
        LOG.info("Email enviado");
    }

    @Override
    public void sendHtmlEmail(MimeMessage msg) {
        LOG.info("Enviando Email...");
        javaMailSender.send(msg);
        LOG.info("Email enviado");
    }


}
