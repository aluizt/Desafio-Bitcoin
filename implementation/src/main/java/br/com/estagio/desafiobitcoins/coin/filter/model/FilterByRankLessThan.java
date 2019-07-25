package br.com.estagio.desafiobitcoins.coin.filter.model;

import br.com.estagio.desafiobitcoins.coin.filter.filter.SimpleFilter;
import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;

import java.util.ArrayList;
import java.util.List;

public class FilterByRankLessThan implements SimpleFilter {
    @Override
    public List<BitCoinsDescription> find(BitCoinsDescriptionRepository repo, String content) {
        List<BitCoinsDescription> listReturn  = new ArrayList<>();
        List<BitCoinsDescription> list = repo.findAllByRankLessThanOrderByRank(Integer.parseInt(content));
        for(BitCoinsDescription b : list){
            if(b.getRank() >0){
                listReturn.add(b);
            }
        }
        return listReturn;
    }
}
