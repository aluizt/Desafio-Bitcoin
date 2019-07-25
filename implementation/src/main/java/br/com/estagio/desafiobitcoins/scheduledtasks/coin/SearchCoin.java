package br.com.estagio.desafiobitcoins.scheduledtasks.coin;


import br.com.estagio.desafiobitcoins.coin.model.BitCoins;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class SearchCoin {

    private final SaveCoin saveCoins;

    public SearchCoin(SaveCoin saveCoins) {
        this.saveCoins = saveCoins;
    }

    public List<BitCoins> getCoins(){
        List<BitCoins> bitCoinsList = getBitCoinsList();
        this.saveCoins.save(bitCoinsList);
        return bitCoinsList;
    }

    private List<BitCoins> getBitCoinsList(){
        final String URL ="https://api.coinpaprika.com/v1/coins";
        RestTemplate coins = new RestTemplate();
        ResponseEntity<List<BitCoins>> exchange =
                coins.exchange(URL,
                        HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<BitCoins>>() {
                        });
        return exchange.getBody();
    }
}
