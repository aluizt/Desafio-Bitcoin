package br.com.estagio.desafiobitcoins.bitcoins;

import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.v1.bitcoins.criteria.Criteria;
import br.com.estagio.desafiobitcoins.v1.bitcoins.model.BitCoinCompleteResponse;
import br.com.estagio.desafiobitcoins.v1.bitcoins.model.BitCoinSimpleResponse;

import java.util.ArrayList;
import java.util.List;


public class BitCoinsTest {

    public List<BitCoinSimpleResponse> listBitCoinSimpleResponse() {
        BitCoinSimpleResponse bsr01 = BitCoinSimpleResponse.builder()
                .id("bitcoin01")
                .name("bitcoin01name")
                .build();
        BitCoinSimpleResponse bsr02 = BitCoinSimpleResponse.builder()
                .id("bitcoin02")
                .name("bitcoin02name")
                .build();
        BitCoinSimpleResponse bsr03 = BitCoinSimpleResponse.builder()
                .id("bitcoin03")
                .name("bitcoin03name")
                .build();
        BitCoinSimpleResponse bsr04 = BitCoinSimpleResponse.builder()
                .id("bitcoin04")
                .name("bitcoin01name")
                .build();

        List<BitCoinSimpleResponse> list = new ArrayList<>();
        list.add(bsr01);
        list.add(bsr02);
        list.add(bsr03);
        list.add(bsr04);
        return list;
    }

    public List<BitCoinsDescription> listbitCoinsDescription(){
        BitCoinsDescription bcd01 = BitCoinsDescription.builder()
                .id("bitcoin001")
                .name("Bicoin001")
                .build();
        BitCoinsDescription bcd02 = BitCoinsDescription.builder()
                .id("bitcoin002")
                .name("Bicoin002")
                .build();
        BitCoinsDescription bcd03 = BitCoinsDescription.builder()
                .id("bitcoin003")
                .name("Bicoin003")
                .build();
        List<BitCoinsDescription> list = new ArrayList<>();
        list.add(bcd01);
        list.add(bcd02);
        list.add(bcd03);
        return list;
    }

    public BitCoinsDescription bitCoinSimpleResponse(){
        return  BitCoinsDescription.builder()
                .id("bitcoin001")
                .name("Bicoin001")
                .build();

    }

    public BitCoinCompleteResponse bitCoinCompleteResponse(){
        return BitCoinCompleteResponse.builder()
                .id("bitcoin")
                .name("Bitcoin")
                .build();
    }

    public List<BitCoinsDescription> listbitCoinsDescriptionByName(){
        BitCoinsDescription bcd01 = BitCoinsDescription.builder()
                .id("bitcoin001")
                .name("Bicoin001")
                .build();

        List<BitCoinsDescription> list = new ArrayList<>();
        list.add(bcd01);
        return list;
    }

    public Criteria criteria(){
        return Criteria.builder()
                .name("bitcoin")
                .build();
    }

}
