package br.com.estagio.desafiobitcoins.coin.filter.model;

import br.com.estagio.desafiobitcoins.coin.filter.filter.SimpleFilter;
import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;

import java.util.List;

public class FilterBySymbol implements SimpleFilter {
    @Override
    public List<BitCoinsDescription> find(BitCoinsDescriptionRepository repo, String content) {
        return repo.findAllBySymbol(content);
    }
}
