package br.com.milvusartis.ecommerce.config;

import br.com.milvusartis.ecommerce.service.DBService;
import br.com.milvusartis.ecommerce.service.EmailService;
import br.com.milvusartis.ecommerce.service.MockEmailService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateDatabase(){
        dbService.intantiateTestDatabase();
        return true;
    }

    @Bean
    public EmailService emailService(){
        return new MockEmailService();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
