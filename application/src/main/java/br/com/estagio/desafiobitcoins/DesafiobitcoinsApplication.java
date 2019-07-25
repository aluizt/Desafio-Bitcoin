package br.com.estagio.desafiobitcoins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class DesafiobitcoinsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesafiobitcoinsApplication.class, args);
    }
}
