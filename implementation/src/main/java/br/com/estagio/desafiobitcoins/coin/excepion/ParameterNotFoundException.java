package br.com.estagio.desafiobitcoins.coin.excepion;

public class ParameterNotFoundException
        extends RuntimeException{

    public ParameterNotFoundException(String message) {

        super(message);
    }
}
