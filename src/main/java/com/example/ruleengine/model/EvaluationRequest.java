package com.example.ruleengine.model;

public class EvaluationRequest {
    private UserData userData;
    private String ruleAst;

    // Getters and Setters
    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String getRuleAst() {
        return ruleAst;
    }

    public void setRuleAst(String ruleAst) {
        this.ruleAst = ruleAst;
    }
}
