package br.com.estagio.desafiobitcoins.scheduledtasks.exchange;

import br.com.estagio.desafiobitcoins.exchange.model.Exchange;
import br.com.estagio.desafiobitcoins.exchangemarket.model.*;
import br.com.estagio.desafiobitcoins.exchangemarket.repository.ExchangeMarketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
@Slf4j
public class SearchExchangeMarket {

    private final SaveExchangeMarket saveExchangeMarket;

    public SearchExchangeMarket(SaveExchangeMarket saveExchangeMarket) {

        this.saveExchangeMarket = saveExchangeMarket;
    }

    public void search(List<Exchange> list){
        ExchangeMarket exchangeMarket = new ExchangeMarket();
        List<ExchangeMarketList> listExchange ;

        for(Exchange b : list){
            listExchange = find(b);
            if(listExchange!=null) {
                exchangeMarket.setId(b.getId());
                exchangeMarket.setList(listExchange);
                this.saveExchangeMarket.save(exchangeMarket);
                for (ExchangeMarketList e : listExchange) {
                    log.info(e.getPair());
                }
            }else log.warn("não encontrado");
        }
    }




    private List<ExchangeMarketList> find(Exchange b){
        String URL="https://api.coinpaprika.com/v1/exchanges/"+ b.getId()+"/markets";
        log.warn(URL);
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<List<ExchangeMarketList>> exchange =
                    restTemplate.exchange(URL,
                            HttpMethod.GET, null,
                            new ParameterizedTypeReference<List<ExchangeMarketList>>() {
                            });


            return exchange.getBody();




        }catch (RuntimeException e ){
            log.error(e.getMessage());
            return null;
        }
    }
}
