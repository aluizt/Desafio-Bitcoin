package br.com.estagio.desafiobitcoins.scheduledtasks.exchange;

import org.springframework.stereotype.Component;
import br.com.estagio.desafiobitcoins.exchangemarket.repository.*;
import br.com.estagio.desafiobitcoins.exchangemarket.model.*;


@Component
public class SaveExchangeMarket {

    private final ExchangeMarketRepository repo;

    public SaveExchangeMarket(ExchangeMarketRepository repo) {
        this.repo = repo;
    }

    public void save(ExchangeMarket exchangeMarket)
    {
        this.repo.save(exchangeMarket);
    }
}
