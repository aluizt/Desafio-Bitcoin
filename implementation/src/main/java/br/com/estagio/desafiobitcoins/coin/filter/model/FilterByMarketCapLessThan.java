package br.com.estagio.desafiobitcoins.coin.filter.model;

import br.com.estagio.desafiobitcoins.coin.excepion.ParameterNotFoundException;
import br.com.estagio.desafiobitcoins.coin.filter.filter.*;
import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FilterByMarketCapLessThan implements SimpleFilter {
    @Override
    public List<BitCoinsDescription> find(BitCoinsDescriptionRepository repo, String content) {
        List<BitCoinsDescription> list = new ArrayList<>();
        List<BitCoinsDescription> listBitCoinsDescription = (List<BitCoinsDescription>) repo.findAll();

        for(BitCoinsDescription b : listBitCoinsDescription){
            if (b.getPrices().getMarketCap() < Long.parseLong(content)) {
                log.info(b.getId());
                list.add(b);
            }
        }
        if(list.isEmpty()){throw new ParameterNotFoundException("Parameter value not found") ;}
        return list;
    }
}
