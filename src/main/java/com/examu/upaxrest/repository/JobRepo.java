package com.examu.upaxrest.repository;

import com.examu.upaxrest.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, Long> {

}
