package com.nnk.springboot.services;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TradeService {



     List<Trade> getAllTrades();

     Trade saveTrade(Trade trade);

     Trade getTradeById(Integer id);

     void deleteTrade(Integer id);
}
