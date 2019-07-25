package br.com.estagio.desafiobitcoins.v1.exchange.model;

import br.com.estagio.desafiobitcoins.exchange.model.Fiats;
import br.com.estagio.desafiobitcoins.exchange.model.Quotes;
import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExchangeResponse {

    private String id;
    private String name;
    private String description;
    private String active;
    @JsonProperty("website_status")
    private String websiteStatus;
    @JsonProperty("api_status")
    private String apiStatus;
    private String message;
    @JsonProperty("markets_data_fetched")
    private String marketsDataFetched;
    @JsonProperty("adjusted_rank")
    private String adjustedRank;
    @JsonProperty("reported_rank")
    private String reportedRank;
    private String currencies;
    private String markets;
    private List<Fiats> fiats;
    private Quotes quotes;
    @JsonProperty("last_updated")
    private String lastUpdated;
}
