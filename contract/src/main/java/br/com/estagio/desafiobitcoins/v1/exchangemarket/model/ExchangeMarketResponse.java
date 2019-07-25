package br.com.estagio.desafiobitcoins.v1.exchangemarket.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import br.com.estagio.desafiobitcoins.exchangemarket.model.*;

import java.util.List;

@Builder
@Getter
@Setter
public class ExchangeMarketResponse {
    private String exchangeName;
}
