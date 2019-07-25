package br.com.estagio.desafiobitcoins.scheduledtasks.coin;

import br.com.estagio.desafiobitcoins.coin.model.*;
import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Semaphore;

@Component
@Slf4j
public class SaveCoin {

    private final BitCoinsDescriptionRepository bitCoinsDescriptionRepository;
    private final FindPrice findPrice;

    public SaveCoin(BitCoinsDescriptionRepository bitCoinsDescriptionRepository, FindPrice findPrice) {
        this.bitCoinsDescriptionRepository = bitCoinsDescriptionRepository;
        this.findPrice = findPrice;
    }

    public void save(List<BitCoins> bitCoinsList){

        RestTemplate coinsDescription = new RestTemplate();
        Semaphore semaphore = new Semaphore(3);

        bitCoinsList.forEach(coin -> {
            try {
                semaphore.acquire();
                new Thread(() -> {
                   BitCoinsDescription bcd = find(coin,coinsDescription);
                   if(bcd !=null){
                       bcd.setPrices(this.findPrice.findPrice(bcd));
                       this.bitCoinsDescriptionRepository.save(bcd);
                       log.info(bcd.getId());
                   }
                    semaphore.release();
                }).start();
            } catch (InterruptedException e) {
               log.error(e.getMessage()+" bitcoin : "+coin.getId());
               Thread.currentThread().interrupt();
            }
        });
    }

    private BitCoinsDescription find(BitCoins b, RestTemplate coinsDescription){
        final String URL = "https://api.coinpaprika.com/v1/coins/" + b.getId();
        try {
            ResponseEntity<BitCoinsDescription> exchange =
                    coinsDescription.exchange(URL,HttpMethod.GET, null,
                            new ParameterizedTypeReference<BitCoinsDescription>() {});
            return exchange.getBody();

        }catch (RuntimeException e ){
            e.getMessage();
            return null;
        }
    }

}
