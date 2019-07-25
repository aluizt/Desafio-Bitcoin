package br.com.estagio.desafiobitcoins.v1.bitcoins.model;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BitCoinSimpleResponse {
    @Id
    @Field
    private String id;
    @Field
    private String name;
    @Field
    private String symbol;
    @Field
    private int rank;
    @Field
    @JsonProperty("is_new")
    private String ene;
    @Field
    @JsonProperty("is_active")
    private String isActive;
    @Field
    private String type;
}
