package br.com.estagio.desafiobitcoins.coin.excepion;

public class BitCoinNotFoundException extends RuntimeException{

    public BitCoinNotFoundException(String message) {
        super(message);
    }
}
