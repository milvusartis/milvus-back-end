package br.com.milvusartis.ecommerce.service.gatway;

import br.com.milvusartis.ecommerce.model.entity.Pagamento;
import br.com.milvusartis.ecommerce.model.pojo.Cartao;
import br.com.milvusartis.ecommerce.service.MockEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PagamentoGatwayService{
    private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);


    public Boolean enviarPagamentoParaConfirmacao(Pagamento pagamento, Cartao cartao){
        //TODO Validar

        Boolean retorno;
        try {
            new GatewayPagamento().confirmaPagamento();
            LOG.info("Pagamento Confirmado!");

            retorno = Boolean.TRUE;
        } catch (InterruptedException e) {
            LOG.info("Pagamento Não Confirmado!");
            retorno = Boolean.FALSE;
        }
        return retorno;


    }
}
