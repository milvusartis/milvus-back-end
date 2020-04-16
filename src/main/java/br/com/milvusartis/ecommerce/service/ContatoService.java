package br.com.milvusartis.ecommerce.service;

import br.com.milvusartis.ecommerce.exception.MailNotSendException;
import br.com.milvusartis.ecommerce.model.dto.ContatoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ContatoService")
public class ContatoService {

    @Autowired
    EmailService emailService;

    public void enviarEmailContato(ContatoDTO contatoDTO) {
        try {
           emailService.sendContact(contatoDTO);
        } catch (Exception ex) {
            throw new MailNotSendException(contatoDTO.toString());
        }
    }
}
