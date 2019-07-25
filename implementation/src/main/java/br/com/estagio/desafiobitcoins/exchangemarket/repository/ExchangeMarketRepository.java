package br.com.estagio.desafiobitcoins.exchangemarket.repository;

import br.com.estagio.desafiobitcoins.exchangemarket.model.*;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
@N1qlSecondaryIndexed(indexName = "exchangesmarket")
@ViewIndexed(designDoc = "exchangeMarket")
public interface ExchangeMarketRepository extends CouchbasePagingAndSortingRepository<ExchangeMarket,String> {

}
