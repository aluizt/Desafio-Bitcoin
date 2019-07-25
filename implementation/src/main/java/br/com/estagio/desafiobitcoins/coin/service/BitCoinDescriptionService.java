package br.com.estagio.desafiobitcoins.coin.service;

import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;
import br.com.estagio.desafiobitcoins.coin.excepion.BitCoinNotFoundException;
import br.com.estagio.desafiobitcoins.coin.filter.filter.SimpleFilter;
import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BitCoinDescriptionService {

    private final BitCoinsDescriptionRepository repository;

    public BitCoinDescriptionService(BitCoinsDescriptionRepository repository) {
        this.repository = repository;
    }

    public List<BitCoinsDescription> findAll(){
        Iterable<BitCoinsDescription> all = this.repository.findAll();
        List<BitCoinsDescription> list =new ArrayList<>();
        all.forEach(list::add);
        return list;
    }
    public BitCoinsDescription findById(String id) {
        return this.repository.findById(id).orElseThrow(() ->
                new BitCoinNotFoundException("BitCoin não localizado .."));
    }

    public List<BitCoinsDescription> findBySimpleFilter(SimpleFilter filter, String content){
        return filter.find(repository,content);
    }

}
