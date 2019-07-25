package br.com.estagio.desafiobitcoins.coin.model;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceReceive {

    @JsonProperty("time_open")
    private String timeOpen;

    @JsonProperty("time_close")
    private String timeClose;

    private double open;

    private double high;

    private double low;

    private double close;

    private double volume;
    @JsonProperty("market_cap")
    private double marketCap;
}
