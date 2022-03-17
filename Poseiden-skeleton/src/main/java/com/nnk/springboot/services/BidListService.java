package com.nnk.springboot.services;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BidListService {

        List<BidList> getAllBids();

        BidList getBidListById(int id) throws Exception;
        void deleteBidListById(int id);

        BidList saveBid(BidList bid);


}
