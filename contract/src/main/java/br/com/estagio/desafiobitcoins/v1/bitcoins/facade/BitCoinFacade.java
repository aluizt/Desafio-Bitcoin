package br.com.estagio.desafiobitcoins.v1.bitcoins.facade;

import br.com.estagio.desafiobitcoins.v1.bitcoins.mapper.BitCoinMapper;
import br.com.estagio.desafiobitcoins.v1.bitcoins.model.BitCoinCompleteResponse;
import br.com.estagio.desafiobitcoins.v1.bitcoins.model.BitCoinSimpleResponse;
import br.com.estagio.desafiobitcoins.coin.facade.ImplCoinFacade;
import br.com.estagio.desafiobitcoins.v1.bitcoins.criteria.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BitCoinFacade {

    private final ImplCoinFacade implCoinFacade;
    private final BitCoinMapper bitCoinMapper;

    public BitCoinFacade(ImplCoinFacade implCoinFacade, BitCoinMapper bitCoinMapper) {
        this.implCoinFacade = implCoinFacade;
        this.bitCoinMapper = bitCoinMapper;
    }

    public List<BitCoinCompleteResponse> findByFilter(Criteria criteria){
        return this.bitCoinMapper.mapToBitCoinCompleteResponseList(
                this.implCoinFacade.findByFilter(this.bitCoinMapper.mapToImplCriteria(criteria)));
    }

    public BitCoinSimpleResponse simpleFindById(String id){
        return this.bitCoinMapper.mapToBitCoinSimpleResponse(this.implCoinFacade.findById(id));
    }

    public BitCoinCompleteResponse completeFindById(String id){
        return this.bitCoinMapper.mapToBitCoinCompleteResponse(this.implCoinFacade.findById(id));
    }

    public List<BitCoinSimpleResponse> simpleFindAll(){
        return this.bitCoinMapper.mapToBitCoinSimpleResponseList(this.implCoinFacade.findAll());
    }

}
