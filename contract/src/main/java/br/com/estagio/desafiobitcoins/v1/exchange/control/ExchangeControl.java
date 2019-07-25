package br.com.estagio.desafiobitcoins.v1.exchange.control;

import br.com.estagio.desafiobitcoins.v1.exchange.facade.ExchangeFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/exchange")
@Api(value = "Exchanges")
public class ExchangeControl {

    private final ExchangeFacade exchangeFacade;

    public ExchangeControl(ExchangeFacade exchangeFacade) {
        this.exchangeFacade = exchangeFacade;
    }

    @PostMapping("/all")
    @ApiOperation(value = "Load the exchanges contained in api " )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success, exchanges loaded"),
            @ApiResponse(code = 401, message = "You are not allowed"),
            @ApiResponse(code = 403, message = "You do not have access to this feature"),
            @ApiResponse(code = 404, message = "Not found")}
    )
    public ResponseEntity saveAllExchange(){
        this.exchangeFacade.saveAllExchange();
        return new ResponseEntity(HttpStatus.OK);
    }

}
