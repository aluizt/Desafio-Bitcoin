package br.com.estagio.desafiobitcoins.coin.filter.model;

import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;
import br.com.estagio.desafiobitcoins.coin.filter.filter.SimpleFilter;
import br.com.estagio.desafiobitcoins.coin.excepion.*;

import java.util.List;


public class FilterByName implements SimpleFilter {

    @Override
    public List<BitCoinsDescription> find(BitCoinsDescriptionRepository repo, String content) {
        List<BitCoinsDescription> bcd= repo.findByName(content);
        if(bcd.isEmpty()) throw new BitCoinNameNotFoundException("Countent not found");
        return bcd;
    }
}
