package com.nnk.springboot.services;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import org.h2.bnf.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RuleService {

     List<RuleName> getAllRules();


     List<RuleName> getAllRuleNames();

     RuleName saveRuleName(RuleName ruleName);

     RuleName getRuleNameById(Integer id);

     void deleteRuleName(Integer id);
}
