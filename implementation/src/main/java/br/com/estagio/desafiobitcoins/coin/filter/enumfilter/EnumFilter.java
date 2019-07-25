package br.com.estagio.desafiobitcoins.coin.filter.enumfilter;
import br.com.estagio.desafiobitcoins.coin.filter.model.*;
import br.com.estagio.desafiobitcoins.coin.filter.filter.*;

public enum  EnumFilter {
    NAME( new FilterByName()),
    ID( new FilterById()),
    MARKETCAPGREATERTHAN(new FilterByMarketCapGreaterThan()),
    MARKETCAPLESSTHAN(new FilterByMarketCapLessThan()),
    RANKGREATERTHAN(new FilterByRankGreaterThan()),
    RANKLESSTHAN(new FilterByRankLessThan()),
    SYMBOL(new FilterBySymbol());

    private SimpleFilter simpleFilter;

    EnumFilter(SimpleFilter simpleFilter){
        this.simpleFilter=simpleFilter;
    }

    public SimpleFilter getSimpleFilter(){
        return simpleFilter;
    }
}
