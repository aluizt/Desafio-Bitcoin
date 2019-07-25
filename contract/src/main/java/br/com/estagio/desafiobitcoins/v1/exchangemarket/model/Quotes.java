package br.com.estagio.desafiobitcoins.v1.exchangemarket.model;

import br.com.estagio.desafiobitcoins.exchange.model.USD;
import lombok.Data;

import java.util.List;

@Data
public class Quotes {
    private List<USD> USD;
}
