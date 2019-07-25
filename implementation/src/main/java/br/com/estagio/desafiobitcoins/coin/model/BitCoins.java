package br.com.estagio.desafiobitcoins.coin.model;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.*;

import org.springframework.data.couchbase.core.mapping.Document;


@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
@ToString
public class BitCoins {

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
    private String isNew;
    @Field
    @JsonProperty("is_active")
    private String active;
    @Field
    private String type;


}


