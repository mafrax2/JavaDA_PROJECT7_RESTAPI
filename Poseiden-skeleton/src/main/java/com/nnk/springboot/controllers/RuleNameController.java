package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.services.RuleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@Log4j2
public class RuleNameController {
    // TODO: Inject RuleName service

    @Autowired
    private RuleService service;

    @RequestMapping("/ruleName/list")
    public String home(Model model)
    {
        // TODO: find all RuleName, add to model
        List<RuleName> allRuleNames = service.getAllRuleNames();
        model.addAttribute("allRuleNames", allRuleNames);

        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list
        if (!result.hasErrors()) {
            service.saveRuleName(ruleName);
            log.info("rule"  + ruleName.getId() +  "has been addded in DB");
            model.addAttribute("allRuleNames", service.getAllRuleNames());
            return "redirect:/ruleName/list";
        }

        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form
        RuleName ruleNameById = service.getRuleNameById(id);
        model.addAttribute("ruleName", ruleNameById);
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                             BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list
        if (result.hasErrors()) {
            return "ruleName/update";
        }

        ruleName.setId(id);
        service.saveRuleName(ruleName);
        log.info("rule"  + ruleName.getId() +  "has been updated in DB");
        model.addAttribute("allRuleNames", service.getAllRuleNames());


        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list

        service.deleteRuleName(id);
        log.info("rule"  + id +  "has been deleted in DB");
        model.addAttribute("allRuleNames", service.getAllRuleNames());

        return "redirect:/ruleName/list";
    }
}
