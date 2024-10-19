package com.example.ruleengine.controller;

import com.example.ruleengine.model.UserAttribute;
import com.example.ruleengine.service.UserAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-attributes")
public class UserAttributeController {

    @Autowired
    private UserAttributeService userAttributeService;

    // Endpoint to create a new user attribute
    @PostMapping
    public ResponseEntity<UserAttribute> createUserAttribute(@RequestBody UserAttribute userAttribute) {
        UserAttribute createdAttribute = userAttributeService.createUserAttribute(userAttribute.getAttributeName(), userAttribute.getAttributeValue());
        return ResponseEntity.ok(createdAttribute);
    }

    // Endpoint to get all user attributes
    @GetMapping
    public ResponseEntity<List<UserAttribute>> getAllUserAttributes() {
        List<UserAttribute> attributes = userAttributeService.getAllUserAttributes();
        return ResponseEntity.ok(attributes);
    }
}
