package br.com.estagio.desafiobitcoins.coin.filter.filter;

import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;

import java.util.List;


public interface SimpleFilter {
    List<BitCoinsDescription> find(BitCoinsDescriptionRepository repo, String content);
}
