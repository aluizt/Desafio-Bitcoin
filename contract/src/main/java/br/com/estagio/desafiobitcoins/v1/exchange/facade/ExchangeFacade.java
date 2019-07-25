package br.com.estagio.desafiobitcoins.v1.exchange.facade;

import br.com.estagio.desafiobitcoins.exchange.facade.ImplExchangeFacade;
import org.springframework.stereotype.Component;

@Component
public class ExchangeFacade {

    private final ImplExchangeFacade implExchangeFacade;

    public ExchangeFacade(ImplExchangeFacade implExchangeFacade) {
        this.implExchangeFacade = implExchangeFacade;
    }

    public void saveAllExchange(){
        this.implExchangeFacade.find();
    }
}
