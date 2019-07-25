package br.com.estagio.desafiobitcoins.coin.model;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Tags {

    private String id;
    private String name;
    @JsonProperty("coin_counter")
    private Integer coinCounter;
    @JsonProperty("ico_counter")
    private Integer icoCounter;

}


