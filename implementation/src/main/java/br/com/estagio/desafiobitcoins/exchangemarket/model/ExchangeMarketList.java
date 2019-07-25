package br.com.estagio.desafiobitcoins.exchangemarket.model;

import br.com.estagio.desafiobitcoins.exchange.model.Quotes;
import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExchangeMarketList {

    private String pair;
    @JsonProperty("base_currency_id")
    private String baseCurrencyId;
    @JsonProperty("base_currency_name")
    private String baseCurrencyName;
    @JsonProperty("quote_currency_id")
    private String quoteCurrencyId;
    @JsonProperty("quote_currency_name")
    private String quoteCurrencyName;
    @JsonProperty("market_url")
    private String marketUrl;
    private String category;
    @JsonProperty("fee_type")
    private String feeType;
    private boolean outlier;
    @JsonProperty("reported_volume_24h_share")
    private double reportedVolume24HShare;
    private Quotes quotes;
    @JsonProperty("last_updated")
    private String lastUpdated;
}
