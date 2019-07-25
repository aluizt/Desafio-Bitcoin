package br.com.estagio.desafiobitcoins.exchange.model;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class USD {
    @JsonProperty("reported_volume_24h")
    private Double reportedVolume24H;
    @JsonProperty("adjusted_volume_24h")
    private Double adjustedVolume24H;
    @JsonProperty("reported_volume_7d")
    private Double reportedVolume7D;
    @JsonProperty("adjusted_volume_7d")
    private Double adjustedVolume7D;
    @JsonProperty("reported_volume_30d")
    private Double reportedVolume30D;
    @JsonProperty("adjusted_volume_30d")
    private Double adjustedVolume30D;

}
