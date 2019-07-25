package br.com.estagio.desafiobitcoins.exchange.repository;

import br.com.estagio.desafiobitcoins.exchange.model.Exchange;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;


@Repository
@N1qlSecondaryIndexed(indexName = "exchange")
@ViewIndexed(designDoc = "exchange")
public interface ExchangeRepository extends CouchbaseRepository<Exchange,String> {
}
