package br.com.estagio.desafiobitcoins.coin.repository;

import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import org.springframework.data.couchbase.core.query.N1qlSecondaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@N1qlSecondaryIndexed(indexName = "bitcoinsdescription")
@ViewIndexed(designDoc = "bitCoinsDescription")
public interface BitCoinsDescriptionRepository extends CouchbasePagingAndSortingRepository<BitCoinsDescription,String> {


    Optional<BitCoinsDescription> findById(String id);

    List<BitCoinsDescription> findByName(String name);

    List<BitCoinsDescription> findAllBySymbol(String symbol);

    List<BitCoinsDescription> findAllByRankGreaterThanOrderByRank(int rank);

    List<BitCoinsDescription> findAllByRankLessThanOrderByRank(int rank);
}
