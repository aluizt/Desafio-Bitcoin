package br.com.estagio.desafiobitcoins.v1.bitcoins.control;

import br.com.estagio.desafiobitcoins.v1.bitcoins.facade.BitCoinFacade;
import br.com.estagio.desafiobitcoins.v1.bitcoins.model.BitCoinCompleteResponse;
import br.com.estagio.desafiobitcoins.v1.bitcoins.model.BitCoinSimpleResponse;
import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;
import br.com.estagio.desafiobitcoins.v1.bitcoins.criteria.Criteria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/bitcoins")
@Api(value = "BitCoins")
public class BitcoinsControl {

    private final BitCoinFacade bitCoinFacade;
    @Autowired
    private BitCoinsDescriptionRepository bitCoinsDescriptionRepository;

    public BitcoinsControl(BitCoinFacade bitCoinFacade) {
        this.bitCoinFacade = bitCoinFacade;
    }

    @GetMapping("/filter")
    @ApiOperation(value = "Search for values provided in the chosen filter " )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success, filter found your content"),
            @ApiResponse(code = 401, message = "You are not allowed"),
            @ApiResponse(code = 403, message = "You do not have access to this feature"),
            @ApiResponse(code = 404, message = "Not found")}
    )
    public ResponseEntity<List<BitCoinCompleteResponse>> findByCriteria(@ModelAttribute Criteria criteria){
        return new ResponseEntity<>((this.bitCoinFacade.findByFilter(criteria)),HttpStatus.OK);
    }

    @GetMapping("/simple/{id}")
    @ApiOperation(value = "Returns bitcoin basic data searching for id " )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Bitcoin success found"),
            @ApiResponse(code = 401, message = "You are not allowed"),
            @ApiResponse(code = 403, message = "You do not have access to this feature"),
            @ApiResponse(code = 404, message = "Not found")}
    )
    public ResponseEntity<BitCoinSimpleResponse> simpleFindById(@PathVariable("id")String id){
      return new ResponseEntity<>(this.bitCoinFacade.simpleFindById(id), HttpStatus.OK);
    }

    @GetMapping("/complete/{id}")
    @ApiOperation(value = "Returns bitcoin complete data searching for id " )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Bitcoin success found"),
            @ApiResponse(code = 401, message = "You are not allowed"),
            @ApiResponse(code = 403, message = "You do not have access to this feature"),
            @ApiResponse(code = 404, message = "Not found")}
    )
    public ResponseEntity<BitCoinCompleteResponse> completeFindById(@PathVariable("id")String id){
        return new ResponseEntity<>(this.bitCoinFacade.completeFindById(id), HttpStatus.OK);
    }

    @GetMapping("/simple")
    @ApiOperation(value = "Returns a list of bitcoin masic data " )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success, returned list"),
            @ApiResponse(code = 401, message = "You are not allowed"),
            @ApiResponse(code = 403, message = "You do not have access to this feature"),
            @ApiResponse(code = 404, message = "Not found")}
    )
    public ResponseEntity<List<BitCoinSimpleResponse>> simpleFindAll(){
        return new ResponseEntity<>(this.bitCoinFacade.simpleFindAll(),HttpStatus.OK);
    }

}
