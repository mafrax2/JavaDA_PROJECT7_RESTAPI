package com.nnk.springboot.unitTest;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.TradeService;
import com.nnk.springboot.services.impl.TradeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TradeServiceTest {

    private List<Trade> trades;
    @Mock
    private TradeRepository repository;


    private TradeService service;


    private static List<Trade> createTrades(){

        Trade trade1 = new Trade("account1", "type1");
        trade1.setTradeId(1);
        Trade trade2 = new Trade("account2", "type2");
        trade2.setTradeId(2);
        Trade trade3 = new Trade("account3", "type3");
        trade3.setTradeId(3);
        Trade trade4 = new Trade("account4", "type4");
        trade4.setTradeId(4);

        List<Trade> trades = Arrays.asList(trade1, trade2, trade3, trade4);
        return  trades;

    }

    @BeforeEach
    private void setUpTests(){
        trades = createTrades();
        service = new TradeServiceImpl(repository);
    }

    @Test
    public void getAllTradesTest(){
        when(repository.findAll()).thenReturn(trades);

        List<Trade> list = createTrades();

        List<Trade> allTrades = service.getAllTrades();

        assertIterableEquals(list, allTrades);

    }

    @Test
    public void getTradeByidTest() throws Exception {

        when(repository.getById(any(Integer.class))).thenReturn(trades.get(0));

        List<Trade> list = createTrades();

        Trade tradeById = service.getTradeById(1);

        assertEquals(list.get(0), tradeById);

    }



    @Test
    public void saveTradeTest(){

        Trade trade = new Trade("account5", "type5");
        trade.setTradeId(5);
        when(repository.save(any(Trade.class))).thenReturn(trade);

        Trade trade1 = service.saveTrade(trade);

        assertEquals(trade, trade1);

    }

}
