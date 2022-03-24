package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.services.BidListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;


@Controller
@Log4j2
public class BidListController {
    // TODO: Inject Bid service

    private final BidListService service;

    public BidListController(BidListService service) {
        this.service = service;
    }

    @RequestMapping("/bidList/list")
    public String home(Model model, Principal user)
    {
        System.out.println(user);
        List<BidList> allBids = service.getAllBids();

        model.addAttribute("allBids", allBids);

        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(Model model) {
        BidList bidList = new BidList();
        model.addAttribute("bidList", bidList);
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return bid list
        if (result.hasErrors()) {
            return "/bidList/add";
        }
        service.saveBid(bid);
        log.info("bidList"  + bid.getBidListId() +  "has been added in DB");
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws Exception {
        // TODO: get Bid by Id and to model then show to the form

        BidList bidListById = service.getBidListById(id);
        model.addAttribute("bidList", bidListById);
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "bidList/update";
        }

        bidList.setBidListId(id);
        service.saveBid(bidList);
        log.info("bidList"  + id +  "has been updated in DB");
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model, Principal user) {
        System.out.println(user);
        // TODO: Find Bid by Id and delete the bid, return to Bid list
        service.deleteBidListById(id);
        log.info("bidList"  + id +  "has been deleted in DB");
        return "redirect:/bidList/list";
    }
}
