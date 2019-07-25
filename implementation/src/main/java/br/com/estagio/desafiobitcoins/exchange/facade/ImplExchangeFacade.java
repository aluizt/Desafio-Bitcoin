package br.com.estagio.desafiobitcoins.exchange.facade;

import br.com.estagio.desafiobitcoins.scheduledtasks.exchange.SaveExchange;
import br.com.estagio.desafiobitcoins.scheduledtasks.exchange.SearchExchange;
import org.springframework.stereotype.Component;

@Component
public class ImplExchangeFacade {

    private final SearchExchange searchExchange;
    private final SaveExchange saveExchange;

    public ImplExchangeFacade(SearchExchange searchExchange, SaveExchange saveExchange) {
        this.searchExchange = searchExchange;
        this.saveExchange = saveExchange;
    }

    public void find(){
        this.saveExchange.save(this.searchExchange.find());
    }
}
