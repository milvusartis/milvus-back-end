package br.com.milvusartis.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SmtpEmailService extends AbstractEmailService{

    private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);


    @Autowired
    MailSender mailSender;



    @Override
    public void sendEmail(SimpleMailMessage msg) {

        LOG.info("Enviando Email...");
        mailSender.send(msg);
        LOG.info("Email enviado");

    }
}
