package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.services.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeService {


    private TradeRepository repository;

    public TradeServiceImpl(TradeRepository repository) {
        this.repository = repository;
    }

    public List<Trade> getAllTrades(){
        return repository.findAll();
    }

    public Trade saveTrade(Trade trade) {
        return repository.save(trade);
    }

    public Trade getTradeById(Integer id) {

        return repository.getById(id);
    }

    public void deleteTrade(Integer id) {
        repository.deleteById(id);
    }
}
