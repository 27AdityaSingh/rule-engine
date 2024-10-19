package com.example.ruleengine.service;

import com.example.ruleengine.model.UserAttribute;
import com.example.ruleengine.repository.UserAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAttributeService {

    @Autowired
    private UserAttributeRepository userAttributeRepository;

    // Method to create a user attribute and store it in the database
    public UserAttribute createUserAttribute(String attributeName, String attributeValue) {
        UserAttribute userAttribute = new UserAttribute();
        userAttribute.setAttributeName(attributeName);
        userAttribute.setAttributeValue(attributeValue);
        return userAttributeRepository.save(userAttribute);
    }

    // Method to retrieve all user attributes from the database
    public List<UserAttribute> getAllUserAttributes() {
        return userAttributeRepository.findAll();
    }
}
