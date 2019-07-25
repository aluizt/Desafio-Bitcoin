package br.com.estagio.desafiobitcoins.scheduledtasks.exchange;

import br.com.estagio.desafiobitcoins.exchange.model.Exchange;
import br.com.estagio.desafiobitcoins.exchange.repository.ExchangeRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveExchange {

    private final ExchangeRepository exchangeRepository;

    public SaveExchange(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    public void save(List<Exchange> list){
        for(Exchange e:list){
            this.exchangeRepository.save(e);
        }
    }
}
