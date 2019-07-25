package br.com.estagio.desafiobitcoins.v1.bitcoins.criteria;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Criteria {



    @ApiParam(value = "Id of cryptocurrency")
    private String id;
    @ApiParam(value = "Name of cryptocurrency")
    private String name;
    @ApiParam(value = "MarketCap greater than")
    private String marketCapGreaterThan;
    @ApiParam(value = "MarketCap less than")
    private String marketCapLessThan;
    @ApiParam(value = "Rank greater than")
    private String rankGreaterThan;
    @ApiParam(value = "Rank less than")
    private String rankLessThan;
    @ApiParam(value = "Symbol of cryptocurrency")
    private String symbol;

}
