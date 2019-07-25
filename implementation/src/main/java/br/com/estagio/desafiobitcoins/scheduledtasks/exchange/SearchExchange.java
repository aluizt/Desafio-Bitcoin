package br.com.estagio.desafiobitcoins.scheduledtasks.exchange;


import br.com.estagio.desafiobitcoins.exchange.model.Exchange;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SearchExchange {

    public List<Exchange> find() {
        RestTemplate exchangeRestTemplate = new RestTemplate();
        ResponseEntity<List<Exchange>> exchangeList =
                exchangeRestTemplate.exchange("https://api.coinpaprika.com/v1/exchanges",
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Exchange>>() {
                        });
        return exchangeList.getBody();
    }
}
