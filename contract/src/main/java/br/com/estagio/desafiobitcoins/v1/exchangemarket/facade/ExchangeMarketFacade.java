package br.com.estagio.desafiobitcoins.v1.exchangemarket.facade;

import br.com.estagio.desafiobitcoins.exchangemarket.facade.ImplExchangeMarketFacade;
import br.com.estagio.desafiobitcoins.v1.exchangemarket.model.ExchangeMarketResponse;
import br.com.estagio.desafiobitcoins.v1.exchangemarket.mapper.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExchangeMarketFacade {

    private final ImplExchangeMarketFacade implExchangeMarketFacade;
    private final ExchangeMarketMap exchangeMarketMap;

    public ExchangeMarketFacade(ImplExchangeMarketFacade implExchangeMarketFacade,
                                ExchangeMarketMap exchangeMarketMap) {
        this.implExchangeMarketFacade = implExchangeMarketFacade;
        this.exchangeMarketMap = exchangeMarketMap;
    }

    public void salveAllExchangeMarket(){
        this.implExchangeMarketFacade.find();
    }

    public List<ExchangeMarketResponse> findExchanges(String bitCoin){
        return this.exchangeMarketMap.mapToExchangeMarketResponse(this.implExchangeMarketFacade.findExchanges(bitCoin));
    }
}
