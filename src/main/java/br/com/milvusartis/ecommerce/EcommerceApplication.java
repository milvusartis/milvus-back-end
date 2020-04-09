package br.com.milvusartis.ecommerce;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/api/ecommerce");
		SpringApplication.run(EcommerceApplication.class, args);
	}

}
