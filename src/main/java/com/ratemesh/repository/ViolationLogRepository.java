package com.ratemesh.repository;

import com.ratemesh.model.ViolationLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationLogRepository extends JpaRepository<ViolationLog, Long>
{

}
