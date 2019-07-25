package br.com.estagio.desafiobitcoins.exchangemarket.facade;

import br.com.estagio.desafiobitcoins.scheduledtasks.exchange.SearchExchange;
import br.com.estagio.desafiobitcoins.scheduledtasks.exchange.SearchExchangeMarket;
import br.com.estagio.desafiobitcoins.exchangemarket.service.*;
import br.com.estagio.desafiobitcoins.exchangemarket.model.*;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ImplExchangeMarketFacade {

    private final SearchExchange searchExchange;
    private final SearchExchangeMarket searchExchangeMarket;
    private final ExchangeMarketService service;
    private final UtilService utilService;

    public ImplExchangeMarketFacade(SearchExchange searchExchange,
                                    SearchExchangeMarket searchExchangeMarket,
                                    ExchangeMarketService service,
                                    UtilService utilService) {
        this.searchExchange = searchExchange;
        this.searchExchangeMarket = searchExchangeMarket;
        this.service = service;
        this.utilService = utilService;
    }

    public void find(){
        this.searchExchangeMarket.search(this.searchExchange.find());
    }

    public List<ExchangeMarket>  findExchanges(String bitCoin){
        return this.utilService.builderList(bitCoin,this.service.findExchanges());
    }
}
