package br.com.estagio.desafiobitcoins.coin.facade;


import br.com.estagio.desafiobitcoins.coin.model.*;
import br.com.estagio.desafiobitcoins.coin.filter.builderfilter.BuilderFilter;
import br.com.estagio.desafiobitcoins.coin.service.BitCoinDescriptionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class ImplCoinFacadeTest {

    @MockBean
    private BitCoinDescriptionService service;

    BitCoinsTest bitCoinsTest;

    @Before
    public void setUp(){
        bitCoinsTest=new BitCoinsTest();
    }

    @Test
    public void searchingIdAndReturningBitcoin(){
        BitCoinsDescription bcd = bitCoinsTest.bitCoinsDescription();
        BDDMockito.when(service.findById(any())).thenReturn(bcd);
        BitCoinsDescription response = this.service.findById(bcd.getId());

        Assert.assertEquals(response.getId(),bcd.getId());
    }

}
