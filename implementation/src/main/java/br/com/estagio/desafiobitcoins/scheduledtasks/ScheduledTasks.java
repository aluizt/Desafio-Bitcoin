package br.com.estagio.desafiobitcoins.scheduledtasks;

import br.com.estagio.desafiobitcoins.scheduledtasks.coin.SearchCoin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Slf4j
public class ScheduledTasks {

    private final SearchCoin searchCoins;
    private int counter=1;

    public ScheduledTasks(SearchCoin searchCoins) {
        this.searchCoins=searchCoins;
    }

    @Scheduled(fixedRate = 1000)
    public void getScheduledTasks() {
        LocalTime localTime = LocalTime.now();
        log.info("*Executando tasks pela "+counter+" vez as "+localTime);
        counter++;
        searchCoins.getCoins();
    }


}
