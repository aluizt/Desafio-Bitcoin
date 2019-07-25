package br.com.estagio.desafiobitcoins.bitcoins;

import br.com.estagio.desafiobitcoins.coin.model.BitCoinsDescription;
import br.com.estagio.desafiobitcoins.coin.repository.BitCoinsDescriptionRepository;
import br.com.estagio.desafiobitcoins.v1.bitcoins.criteria.Criteria;
import br.com.estagio.desafiobitcoins.v1.bitcoins.model.BitCoinCompleteResponse;
import br.com.estagio.desafiobitcoins.v1.bitcoins.model.BitCoinSimpleResponse;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BitCoinsControlTest {

    final String URL ="/v1/bitcoins";

    @MockBean
    private BitCoinsDescriptionRepository repo;
    @Autowired
    private TestRestTemplate testRestTemplate;
    BitCoinsTest bitCoinsTest;

    @Before
    public void setUp(){
         bitCoinsTest = new BitCoinsTest();
    }

    @Test
    public void listingBitCoinsAndReturningStatusCode200(){
        List<BitCoinsDescription> list= bitCoinsTest.listbitCoinsDescription();
        BDDMockito.when(repo.findAll()).thenReturn(list);
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(URL+"/simple",String.class);

        Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void searchingBitVoinsForIdReturnComplete(){
        BitCoinsDescription bitCoin = bitCoinsTest.bitCoinSimpleResponse();
        BDDMockito.when(repo.findById(any())).thenReturn(java.util.Optional.ofNullable(bitCoin));
        ResponseEntity<BitCoinCompleteResponse> responseEntity =
                testRestTemplate.getForEntity(URL+"/complete/"+bitCoin.getId(),
                        BitCoinCompleteResponse.class);

        Assert.assertEquals(responseEntity.getBody().getId(),bitCoin.getId());
    }

    @Test
    public void searchingBitVoinsForIdReturnSimple(){
        BitCoinsDescription bitCoin = bitCoinsTest.bitCoinSimpleResponse();
        BDDMockito.when(repo.findById(any())).thenReturn(java.util.Optional.ofNullable(bitCoin));
        ResponseEntity<BitCoinSimpleResponse> responseEntity =
                testRestTemplate.getForEntity(URL+"/simple/"+bitCoin.getId(),
                        BitCoinSimpleResponse.class);

        Assert.assertEquals(responseEntity.getBody().getId(),bitCoin.getId());
    }

    @Test
    public void searchingWithTheNameFilter(){
        List<BitCoinsDescription> bcr = bitCoinsTest.listbitCoinsDescriptionByName();
        BDDMockito.when(repo.findByName(any())).thenReturn(bcr);
        ResponseEntity<List<BitCoinsDescription>> responseEntity =
                testRestTemplate.exchange(URL+"/filter?name=bitcoin",HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<BitCoinsDescription>>() {
                        });

        Assert.assertEquals(responseEntity.getBody().get(0).getId(),bcr.get(0).getId());
    }
}

















