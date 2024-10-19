package com.example.ruleengine.model;

import javax.persistence.*;

@Entity
@Table(name = "rules") // Specify the table name in the database
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_name", nullable = false) // Specify the column name and constraints
    private String ruleName;

    @Column(name = "rule_ast", nullable = false) // Specify the column name and constraints
    private String ruleAst;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleAst() {
        return ruleAst;
    }

    public void setRuleAst(String ruleAst) {
        this.ruleAst = ruleAst;
    }
}

