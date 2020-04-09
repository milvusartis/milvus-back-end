package br.com.milvusartis.ecommerce.config;

import br.com.milvusartis.ecommerce.service.DBService;
import br.com.milvusartis.ecommerce.service.EmailService;
import br.com.milvusartis.ecommerce.service.MockEmailService;
import br.com.milvusartis.ecommerce.service.SmtpEmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {
    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instantiateDatabase(){
        if(!"create".equals(strategy)){
            System.out.println(strategy);
            return false;
        }
       dbService.intantiateTestDatabase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
