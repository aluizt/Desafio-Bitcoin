package br.com.estagio.desafiobitcoins.exchangemarket.service;

import br.com.estagio.desafiobitcoins.exchangemarket.model.ExchangeMarket;
import br.com.estagio.desafiobitcoins.exchangemarket.model.ExchangeMarketList;
import br.com.estagio.desafiobitcoins.exchangemarket.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UtilService {

    public List<ExchangeMarket> builderList(String bitCoin,List<ExchangeMarket> marketList ){
        List<ExchangeMarket> listExchange = new ArrayList<>();
        List<ExchangeMarketList> list;
        List<ExchangeMarketList> listExchangesList;

        for (ExchangeMarket e : marketList){
            list = e.getList();
            listExchangesList = new ArrayList<>();
            for (ExchangeMarketList m :list){
                if(m.getBaseCurrencyId().equalsIgnoreCase(bitCoin)|| m.getQuoteCurrencyId().equalsIgnoreCase(bitCoin)){
                    listExchangesList.add(m);
                }
            }
            if(!listExchangesList.isEmpty()){
                listExchange.add(new ExchangeMarket(e.getId(),listExchangesList));
            }
        }
        if(listExchange.isEmpty())throw new ExchangeMarketException("BitCoin not found");
        return listExchange;
    }
}
