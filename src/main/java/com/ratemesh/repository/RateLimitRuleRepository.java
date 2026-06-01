package com.ratemesh.repository;

import com.ratemesh.model.Client;
import com.ratemesh.model.RateLimitRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateLimitRuleRepository extends JpaRepository<RateLimitRule, Long>
{
    List<RateLimitRule> findByClient(Client client);
}
