package br.com.estagio.desafiobitcoins.coin.model;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import lombok.*;
import org.springframework.data.couchbase.core.mapping.Document;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document
public class BitCoinsDescription {

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
    @Field
    private List<Tags> tags;
    @Field
    private List<Team> team;
    @Field
    private String description;
    @Field
    private String message;
    @Field
    @JsonProperty("open_source")
    private String openSource;
    @Field
    @JsonProperty("started_at")
    private String startedAt;
    @Field
    @JsonProperty("development_status")
    private String developmentStatus;
    @Field
    @JsonProperty("hardware_wallet")
    private String hardwareWallet;
    @Field
    @JsonProperty("proof_type")
    private String proofType;
    @Field
    @JsonProperty("org_structure")
    private String orgStructure;
    @Field
    @JsonProperty("hash_algorithm")
    private String hashAlgorithm;
    @Field
    @JsonProperty("first_data_at")
    private String firstDataAt;
    @Field
    @JsonProperty("last_data_at")
    private String lastDataAt;
    @Field
    private PriceReceive prices;



}
