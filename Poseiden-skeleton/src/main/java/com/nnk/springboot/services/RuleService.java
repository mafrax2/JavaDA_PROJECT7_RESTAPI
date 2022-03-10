package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.h2.bnf.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuleService {

    @Autowired
    private RuleNameRepository repository;


    public List<RuleName> getAllRules(){
        return repository.findAll();
    }


    public List<RuleName> getAllRuleNames() {
        return repository.findAll();
    }

    public RuleName saveRuleName(RuleName ruleName) {

    return repository.save(ruleName);
    }

    public RuleName getRuleNameById(Integer id) {
        RuleName ruleName = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        return ruleName;
    }

    public void deleteRuleName(Integer id) {
        repository.deleteById(id);
    }
}
