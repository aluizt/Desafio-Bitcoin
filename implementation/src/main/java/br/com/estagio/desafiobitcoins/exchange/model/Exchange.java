package br.com.estagio.desafiobitcoins.exchange.model;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Exchange {

    @Id
    @Field
    private String id;
    @Field
    private String name;
    @Field
    private String description;
    @Field
    private String active;
    @Field
    @JsonProperty("website_status")
    private String websiteStatus;
    @Field
    @JsonProperty("api_status")
    private String apiStatus;
    @Field
    private String message;
    @Field
    @JsonProperty("markets_data_fetched")
    private String marketsDataFetched;
    @Field
    @JsonProperty("adjusted_rank")
    private String adjustedRank;
    @Field
    @JsonProperty("reported_rank")
    private String reportedRank;
    @Field
    private String currencies;
    @Field
    private String markets;
    @Field
    private List<Fiats> fiats;
    @Field
    private Quotes quotes;
    @Field
    @JsonProperty("last_updated")
    private String lastUpdated;



}
