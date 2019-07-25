package br.com.estagio.desafiobitcoins.coin.facade;

import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;

import java.util.ArrayList;
import java.util.List;


public class BitCoinsTest {


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

    public BitCoinsDescription bitCoinsDescription(){
        return  BitCoinsDescription.builder()
                .id("bitcoin001")
                .name("Bicoin001")
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


}
