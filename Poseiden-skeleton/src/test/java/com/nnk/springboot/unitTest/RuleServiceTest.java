package com.nnk.springboot.unitTest;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;

import com.nnk.springboot.services.RuleService;

import com.nnk.springboot.services.impl.RuleServiceImpl;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RuleServiceTest {

    private List<RuleName> rules;
    @Mock
    private RuleNameRepository repository;


    private RuleService service;


    private static List<RuleName> createRules(){

        RuleName rule1 = new RuleName("name1", "desc1", "json1", "template1", "sql1", "sqlPart1");
        rule1.setId(1);
        RuleName rule2 = new RuleName("name2", "desc2", "json2", "template2", "sql2", "sqlPart2");
        rule2.setId(2);
        RuleName rule3 = new RuleName("name3", "desc3", "json3", "template3", "sql3", "sqlPart3");
        rule3.setId(3);
        RuleName rule4 = new RuleName("name4", "desc4", "json4", "template4", "sql4", "sqlPart4");
        rule4.setId(4);

        List<RuleName> rules = Arrays.asList(rule1, rule2, rule3, rule4);
        return  rules;

    }

    @BeforeEach
    private void setUpTests(){
        rules = createRules();
        service = new RuleServiceImpl(repository);
    }

    @Test
    public void getAllrulesTest(){
        when(repository.findAll()).thenReturn(rules);

        List<RuleName> list = createRules();

        List<RuleName> allrules = service.getAllRuleNames();

        assertIterableEquals(list, allrules);

    }

    @Test
    public void getruleByidTest() throws Exception {

        when(repository.findById(any(Integer.class))).thenReturn(Optional.ofNullable(rules.get(0)));

        List<RuleName> list = createRules();

        RuleName RuleNameById = service.getRuleNameById(1);

        assertEquals(list.get(0), RuleNameById);

    }



    @Test
    public void saveruleTest(){

        RuleName ruleName = new RuleName("name5", "desc5", "json5", "template5", "sql5", "sqlPart5");
        ruleName.setId(5);
        when(repository.save(any(RuleName.class))).thenReturn(ruleName);

        RuleName ruleName1 = service.saveRuleName(ruleName);

        assertEquals(ruleName, ruleName1);

    }

}
