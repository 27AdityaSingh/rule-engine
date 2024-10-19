package com.example.ruleengine.repository;

import com.example.ruleengine.model.UserAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAttributeRepository extends JpaRepository<UserAttribute, Long> {
}
