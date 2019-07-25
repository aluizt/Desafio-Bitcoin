package br.com.estagio.desafiobitcoins.exchange.service;


import br.com.estagio.desafiobitcoins.exchange.model.Exchange;
import br.com.estagio.desafiobitcoins.exchange.repository.ExchangeRepository;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;

    public ExchangeService(ExchangeRepository exchangeRepository){
        this.exchangeRepository=exchangeRepository;
    }


    public Exchange teste(Exchange exchange){
       return exchangeRepository.save(exchange);
    }
}
