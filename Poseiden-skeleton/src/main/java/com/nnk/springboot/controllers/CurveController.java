package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.services.CurvePointService;
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
import java.util.List;

@Controller
@Log4j2
public class CurveController {
    // TODO: Inject Curve Point service

    @Autowired
    private CurvePointService service;

    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
        // TODO: find all Curve Point, add to model

        List<CurvePoint> allCurvePoints = service.getAllCurvePoints();
        model.addAttribute("allCurvePoints", allCurvePoints);

        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint curvePoint ) {

        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public ModelAndView validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list

        if (result.hasErrors()) {
            return new ModelAndView("redirect:/curvePoint/add");
        }

        service.saveCurvePoint(curvePoint);
        log.info("curvePoint"  + curvePoint.getId() +  "has been added in DB");
        return new ModelAndView("redirect:/curvePoint/list");
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws Exception {
        // TODO: get CurvePoint by Id and to model then show to the form
        CurvePoint curvePointById = service.getCurvePointById(id);
        model.addAttribute("curvePoint", curvePointById);
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list
        if (result.hasErrors()) {
            return "curvePoint/update";
        }
        curvePoint.setId(id);
        service.saveCurvePoint(curvePoint);
        log.info("curvePoint"  + curvePoint.getId() +  "has been updated in DB");
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list

        service.deleteCurvePointById(id);
        log.info("curvePoint"  + id +  "has been deleted in DB");
        return "redirect:/curvePoint/list";
    }
}
