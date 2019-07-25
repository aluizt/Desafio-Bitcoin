package br.com.estagio.desafiobitcoins.v1.exchangemarket.control;

import br.com.estagio.desafiobitcoins.v1.exchangemarket.facade.ExchangeMarketFacade;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.estagio.desafiobitcoins.v1.exchangemarket.model.*;

import java.util.List;

@RestController
@RequestMapping("/v1/market")
@Api(value = "Market")
public class ExchangeMarketControl {
    private final ExchangeMarketFacade exchangeMarketFacade;

    public ExchangeMarketControl(ExchangeMarketFacade exchangeMarketFacade) {
        this.exchangeMarketFacade = exchangeMarketFacade;
    }

    @GetMapping("/{bitCoin}")
    @ApiOperation(value = "List the exchanges that work with the desired cryptocurrency " )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success, exchanges found"),
            @ApiResponse(code = 401, message = "You are not allowed"),
            @ApiResponse(code = 403, message = "You do not have access to this feature"),
            @ApiResponse(code = 404, message = "Not found")}
    )
    public ResponseEntity<List<ExchangeMarketResponse>> findExchange(
            @PathVariable("bitCoin") String bitCoin){
        return new ResponseEntity<>(this.exchangeMarketFacade.findExchanges(bitCoin),HttpStatus.OK);
    }


    @PostMapping("/all")
    @ApiOperation(value = "Load the exchanges contained in api " )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success, exchanges loaded"),
            @ApiResponse(code = 401, message = "You are not allowed"),
            @ApiResponse(code = 403, message = "You do not have access to this feature"),
            @ApiResponse(code = 404, message = "Not found")}
    )
    public ResponseEntity savaAllMarket(){
       this.exchangeMarketFacade.salveAllExchangeMarket();
       return new ResponseEntity(HttpStatus.OK);
    }
}
