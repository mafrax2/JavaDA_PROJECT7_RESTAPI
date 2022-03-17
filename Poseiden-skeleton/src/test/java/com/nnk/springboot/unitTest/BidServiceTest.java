package com.nnk.springboot.unitTest;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.services.BidListService;
import com.nnk.springboot.services.impl.BidListServiceImpl;
import org.junit.jupiter.api.BeforeAll;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BidServiceTest {

    private List<BidList> bids;
    @Mock
    private BidListRepository repository;


    private BidListService service;


    private static List<BidList> createBids(){

        BidList bid1 = new BidList("account1", "type1", 1.0);
        bid1.setBidListId(1);
        BidList bid2 = new BidList("account2", "type2", 1.0);
        bid2.setBidListId(2);
        BidList bid3 = new BidList("account3", "type3", 1.0);
        bid3.setBidListId(3);
        BidList bid4 = new BidList("account4", "type4", 1.0);
        bid4.setBidListId(4);

        List<BidList> bidList = Arrays.asList(bid1, bid2, bid3, bid4);
        return  bidList;

    }

    @BeforeEach
    private void setUpTests(){
        bids = createBids();
        service = new BidListServiceImpl(repository);
    }

    @Test
    public void getAllBidsTest(){
        when(repository.findAll()).thenReturn(bids);

        List<BidList> list = createBids();

        List<BidList> allBids = service.getAllBids();

        assertIterableEquals(list, allBids);

    }

    @Test
    public void getBidByidTest() throws Exception {

        when(repository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(bids.get(0)));

        List<BidList> list = createBids();

        BidList bidListById = service.getBidListById(1);

        assertEquals(list.get(0), bidListById);

    }


    @Test
    public void saveBidTest(){

        BidList bidList = new BidList("account5", "type5", 1.0);
        bidList.setBidListId(5);
        when(repository.save(any(BidList.class))).thenReturn(bidList);

        BidList bidList1 = service.saveBid(bidList);

        assertEquals(bidList, bidList1);

    }

}
