
package com.example.ruleengine.controller;

import com.example.ruleengine.model.Rule;
import com.example.ruleengine.model.UserData; // Import UserData model
import com.example.ruleengine.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleService ruleService;

    // Endpoint to create a new rule
    @PostMapping
    public ResponseEntity<Rule> createRule(@RequestBody Rule rule) {
        Rule createdRule = ruleService.createRule(rule.getRuleName(), rule.getRuleAst());
        return ResponseEntity.ok(createdRule);
    }

    // Endpoint to get all rules
    @GetMapping
    public ResponseEntity<List<Rule>> getAllRules() {
        List<Rule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }

    // Endpoint to get a specific rule by ID
    @GetMapping("/{id}")
    public ResponseEntity<Rule> getRuleById(@PathVariable Long id) {
        Optional<Rule> rule = ruleService.getRuleById(id);
        return rule.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint to combine multiple rules (example)
    @PostMapping("/combine")
    public ResponseEntity<String> combineRules(@RequestBody List<Rule> rules) {
        String combinedAst = ruleService.combineRules(rules);
        return ResponseEntity.ok(combinedAst);
    }

    // Endpoint to evaluate a rule against user data
    @PostMapping("/evaluate")
    public ResponseEntity<Boolean> evaluateRule(@RequestBody UserData userData, @RequestParam String ruleAst) {
        boolean result = ruleService.evaluateRule(ruleAst, userData);
        return ResponseEntity.ok(result);
    }
}
