package br.com.estagio.desafiobitcoins.coin.facade;

import br.com.estagio.desafiobitcoins.coin.filter.builderfilter.*;
import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.coin.service.BitCoinDescriptionService;
import br.com.estagio.desafiobitcoins.coin.criteria.ImplCriteria;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImplCoinFacade {

    private final BitCoinDescriptionService bitCoinDescriptionService;
    private final BuilderFilter builderFilter;

    public ImplCoinFacade(BitCoinDescriptionService bitCoinDescriptionService,
                          BuilderFilter builderFilter) {
        this.bitCoinDescriptionService = bitCoinDescriptionService;
        this.builderFilter = builderFilter;
    }

    public BitCoinsDescription findById(String id) {
        return this.bitCoinDescriptionService.findById(id);
    }

    public List<BitCoinsDescription> findAll() {
        return this.bitCoinDescriptionService.findAll();
    }

    public List<BitCoinsDescription> findByFilter(ImplCriteria implCriteria) {
        return this.bitCoinDescriptionService.findBySimpleFilter(
                this.builderFilter.findField(implCriteria),
                this.builderFilter.findContent(implCriteria));
    }

}


