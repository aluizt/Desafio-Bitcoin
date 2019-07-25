package br.com.estagio.desafiobitcoins.scheduledtasks.coin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import br.com.estagio.desafiobitcoins.coin.model.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class FindPrice {

    public PriceReceive findPrice(BitCoinsDescription bitCoinsDescription){
        final String URL = "https://api.coinpaprika.com/v1/coins/"+bitCoinsDescription.getId()+"/ohlcv/latest";
        RestTemplate priceReceive = new RestTemplate();
        try {

            ResponseEntity<List<PriceReceive>> exchange = priceReceive.exchange(URL,
                    HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<PriceReceive>>() {});

            log.info("Find price : "+exchange.getBody().get(0).getHigh());

            return exchange.getBody().get(0);

        }catch (RuntimeException e){

            log.warn(e.getMessage());

            return PriceReceive.builder()
                    .marketCap(0)
                    .close(0)
                    .high(0)
                    .low(0)
                    .open(0)
                    .timeClose("")
                    .timeOpen("")
                    .volume(0)
                    .build();
        }
    }
}
