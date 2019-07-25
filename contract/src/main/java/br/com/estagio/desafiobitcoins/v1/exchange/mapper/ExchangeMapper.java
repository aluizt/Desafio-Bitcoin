package br.com.estagio.desafiobitcoins.v1.exchange.mapper;

import br.com.estagio.desafiobitcoins.exchange.model.Exchange;
import br.com.estagio.desafiobitcoins.v1.exchange.model.ExchangeResponse;
import org.springframework.stereotype.Service;

@Service
public class ExchangeMapper {

    public ExchangeResponse mapToExchangeResponse(Exchange exchange){
        return ExchangeResponse.builder()
                .active(exchange.getActive())
                .adjustedRank(exchange.getAdjustedRank())
                .apiStatus(exchange.getApiStatus())
                .currencies(exchange.getCurrencies())
                .description(exchange.getDescription())
                .fiats(exchange.getFiats())
                .id(exchange.getId())
                .lastUpdated(exchange.getLastUpdated())
                .markets(exchange.getMarkets())
                .marketsDataFetched(exchange.getMarketsDataFetched())
                .message(exchange.getMessage())
                .name(exchange.getName())
                .quotes(exchange.getQuotes())
                .reportedRank(exchange.getReportedRank())
                .websiteStatus(exchange.getWebsiteStatus())
                .build();
    }
}
