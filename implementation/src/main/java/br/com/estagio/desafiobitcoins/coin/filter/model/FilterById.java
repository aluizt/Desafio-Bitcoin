package br.com.estagio.desafiobitcoins.coin.filter.model;

import br.com.estagio.desafiobitcoins.coin.filter.filter.SimpleFilter;
import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;
import br.com.estagio.desafiobitcoins.coin.excepion.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilterById implements SimpleFilter {
    @Override
    public List<BitCoinsDescription> find(BitCoinsDescriptionRepository repo, String content) {
        Optional<BitCoinsDescription> optional = repo.findById(content);
        List<BitCoinsDescription> list = new ArrayList<>();
        list.add(optional.orElseThrow(() -> new ParameterNotFoundException("Countent not found")));
        return list;
    }
}
