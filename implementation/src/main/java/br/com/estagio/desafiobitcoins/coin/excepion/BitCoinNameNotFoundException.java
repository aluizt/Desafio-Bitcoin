package br.com.estagio.desafiobitcoins.coin.excepion;

public class BitCoinNameNotFoundException extends RuntimeException {
    public BitCoinNameNotFoundException(String message) {
        super(message);
    }
}
