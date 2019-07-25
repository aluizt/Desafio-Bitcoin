package br.com.estagio.desafiobitcoins.config;

import br.com.estagio.desafiobitcoins.exchange.model.Exchange;
import br.com.estagio.desafiobitcoins.exchangemarket.model.*;
import com.couchbase.client.java.Bucket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;
import org.springframework.data.couchbase.repository.support.IndexManager;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MyCouchbaseConfig extends AbstractCouchbaseConfiguration {

   private static final String GERAL = "123456";


    @Bean
    public Bucket exchangesMarketBucket() throws Exception {
        return couchbaseCluster().openBucket("exchangesmarket", GERAL);
    }

    @Bean
    public CouchbaseTemplate exchangesMarketTemplate() throws Exception {
        CouchbaseTemplate couchbaseTemplate = new
                CouchbaseTemplate(couchbaseClusterInfo(),
                exchangesMarketBucket(),
                mappingCouchbaseConverter(),
                translationService());
        couchbaseTemplate.setDefaultConsistency(getDefaultConsistency());
        return couchbaseTemplate;
    }

    @Bean
    public Bucket exchangesBucket() throws Exception {
        return couchbaseCluster().openBucket("exchanges", GERAL);
    }
    @Bean
    public CouchbaseTemplate exchangesTemplate() throws Exception {
        CouchbaseTemplate couchbaseTemplate = new
                CouchbaseTemplate(couchbaseClusterInfo(),
                exchangesBucket(),
                mappingCouchbaseConverter(),
                translationService());
        couchbaseTemplate.setDefaultConsistency(getDefaultConsistency());
        return couchbaseTemplate;
    }

    @Override
    protected void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
        try {
            mapping
                    .mapEntity(Exchange.class, exchangesTemplate())
                    .mapEntity(ExchangeMarket.class, exchangesMarketTemplate());
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.configureRepositoryOperationsMapping(mapping);
    }


    @Override
    protected List<String> getBootstrapHosts() {
        return Arrays.asList("localhost");
    }

    @Override
    protected String getBucketName() {
        return "bitcoinsdescription";
    }

    @Override
    protected String getBucketPassword() {
        return GERAL;
    }

    @Override
    public IndexManager indexManager() {
        return new IndexManager(true,true,true);
    }
}
