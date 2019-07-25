package br.com.estagio.desafiobitcoins.coin.model;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {
    @Id
    @Field
    private String idPrice;
    @Field
    @JsonProperty("time_open")
    private String timeOpen;
    @Field
    @JsonProperty("time_close")
    private String timeClose;
    @Field
    private double open;
    @Field
    private double high;
    @Field
    private double low;
    @Field
    private double close;
    @Field
    private double volume;
    @Field
    @JsonProperty("market_cap")
    private double marketCap;
}
