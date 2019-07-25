package br.com.estagio.desafiobitcoins.coin.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImplCriteria {
    private String id;
    private String name;
    private String marketCapGreaterThan;
    private String marketCapLessThan;
    private String rankGreaterThan;
    private String rankLessThan;
    private String symbol;
}
