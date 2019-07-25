package br.com.estagio.desafiobitcoins.exchangemarket.service;

import br.com.estagio.desafiobitcoins.exchangemarket.exception.ExchangeMarketException;
import br.com.estagio.desafiobitcoins.exchangemarket.repository.ExchangeMarketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import br.com.estagio.desafiobitcoins.exchangemarket.model.*;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ExchangeMarketService {

    private final ExchangeMarketRepository repository;

    public ExchangeMarketService(ExchangeMarketRepository repository) {
        this.repository = repository;
    }

    public List<ExchangeMarket> findExchanges() {
        Iterable<ExchangeMarket> iterable = this.repository.findAll();
        List<ExchangeMarket> list = new ArrayList<>();
        iterable.forEach(list::add);
        if(list.isEmpty())throw new ExchangeMarketException("Exchange Market error");
        return list;
    }
}
