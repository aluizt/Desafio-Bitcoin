package br.com.estagio.desafiobitcoins.v1.exchangemarket.mapper;

import br.com.estagio.desafiobitcoins.exchangemarket.model.*;
import br.com.estagio.desafiobitcoins.v1.exchangemarket.model.ExchangeMarketResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExchangeMarketMap {

    public List<ExchangeMarketResponse> mapToExchangeMarketResponse(List<ExchangeMarket> exchangeMarket){
        List<ExchangeMarketResponse> listResponse = new ArrayList<>();

        for(ExchangeMarket e : exchangeMarket){
            listResponse.add(ExchangeMarketResponse.builder()
                    .exchangeName(e.getId())
                    .build());
        }
        return listResponse;
    }
}
