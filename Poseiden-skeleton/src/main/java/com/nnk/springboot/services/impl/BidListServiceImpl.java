package com.nnk.springboot.services.impl;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidListServiceImpl implements BidListService {


        private final BidListRepository repository;

    public BidListServiceImpl(BidListRepository repository) {
        this.repository = repository;
    }


    public List<BidList> getAllBids(){
            return repository.findAll();
        }

        public BidList getBidListById(int id) throws Exception {
            return repository.findById(id).orElseThrow(() -> new Exception("BidList not found"));
        }

        public void deleteBidListById(int id){
            repository.deleteById(id);
        }

        public BidList saveBid(BidList bid){
            return repository.save(bid);
        }


}
