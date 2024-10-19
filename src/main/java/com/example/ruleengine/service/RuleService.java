

package com.example.ruleengine.service;

import com.example.ruleengine.model.Rule;
import com.example.ruleengine.model.UserData;
import com.example.ruleengine.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    // Method to create a rule and store it in the database
    public Rule createRule(String ruleName, String ruleAst) {
        Rule rule = new Rule();
        rule.setRuleName(ruleName);
        rule.setRuleAst(ruleAst);
        return ruleRepository.save(rule);
    }

    // Method to retrieve all rules from the database
    public List<Rule> getAllRules() {
        return ruleRepository.findAll();
    }

    // Method to retrieve a rule by its ID
    public Optional<Rule> getRuleById(Long id) {
        return ruleRepository.findById(id);
    }

    // Method to combine multiple rules
    public String combineRules(List<Rule> rules) {
        StringBuilder combinedAst = new StringBuilder();
        for (Rule rule : rules) {
            combinedAst.append(rule.getRuleAst()).append(" AND ");
        }
        // Remove the last " AND "
        if (combinedAst.length() > 0) {
            combinedAst.setLength(combinedAst.length() - 5); // Remove the last " AND "
        }
        return combinedAst.toString();
    }

    // Method to evaluate a rule against user data
    public boolean evaluateRule(String ruleAst, UserData userData) {
        // Extract user attributes
        int age = userData.getAge();
        String department = userData.getDepartment();
        double salary = userData.getSalary();
        int experience = userData.getExperience();

        // Initialize conditions
        boolean result = true; // Start with a default of true

        // Split the ruleAst into parts by handling AND/OR correctly
        String[] orConditions = ruleAst.split(" OR "); // Split by OR
        for (String orCondition : orConditions) {
            boolean orResult = true; // Start each OR condition as true
            String[] andConditions = orCondition.split(" AND "); // Split by AND
            for (String condition : andConditions) {
                condition = condition.trim(); // Clean up whitespace
                boolean conditionResult = false; // Default for each condition
                if (condition.startsWith("age")) {
                    conditionResult = evaluateAgeCondition(condition, age);
                } else if (condition.startsWith("department")) {
                    conditionResult = evaluateDepartmentCondition(condition, department);
                } else if (condition.startsWith("salary")) {
                    conditionResult = evaluateSalaryCondition(condition, salary);
                } else if (condition.startsWith("experience")) {
                    conditionResult = evaluateExperienceCondition(condition, experience);
                }
                orResult = orResult && conditionResult; // Combine results for AND
            }
            result = result && orResult; // Combine results for OR
        }
        
        return result; // Return the final evaluation result
    }

    // Helper methods for condition evaluation
    private boolean evaluateAgeCondition(String condition, int age) {
        if (condition.contains(">")) {
            return age > Integer.parseInt(condition.split(">")[1].trim());
        } else if (condition.contains("<")) {
            return age < Integer.parseInt(condition.split("<")[1].trim());
        }
        return false;
    }

    private boolean evaluateDepartmentCondition(String condition, String department) {
        if (condition.contains("=")) {
            return department.equals(condition.split("=")[1].trim().replace("'", ""));
        }
        return false;
    }

    private boolean evaluateSalaryCondition(String condition, double salary) {
        if (condition.contains(">")) {
            return salary > Double.parseDouble(condition.split(">")[1].trim());
        }
        return false;
    }

    private boolean evaluateExperienceCondition(String condition, int experience) {
        if (condition.contains(">")) {
            return experience > Integer.parseInt(condition.split(">")[1].trim());
        }
        return false;
    }
}
