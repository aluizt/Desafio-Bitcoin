package br.com.estagio.desafiobitcoins.v1.bitcoins.model;

import br.com.estagio.desafiobitcoins.coin.model.PriceReceive;
import br.com.estagio.desafiobitcoins.coin.model.Tags;
import br.com.estagio.desafiobitcoins.coin.model.Team;
import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BitCoinCompleteResponse {

    private String id;
    private String name;
    private String symbol;
    private int rank;
    @JsonProperty("is_new")
    private String ene;
    private String isActive;
    private String type;
    private List<Tags> tags;
    private List<Team> team;
    private String description;
    private String message;
    private String openSource;
    private String startEDat;
    private String developmentStatus;
    private String hardWreWallet;
    private String proofType;
    private String orgStructure;
    private String hashAlgorithm;
    private String firstDatAat;
    private String lastDatAat;
    private PriceReceive prices;
}
