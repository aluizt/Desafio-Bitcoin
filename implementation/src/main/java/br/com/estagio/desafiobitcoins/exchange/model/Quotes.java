package br.com.estagio.desafiobitcoins.exchange.model;

import lombok.Data;

import java.util.List;

@Data
public class Quotes {
    private List<USD> USD;
}
