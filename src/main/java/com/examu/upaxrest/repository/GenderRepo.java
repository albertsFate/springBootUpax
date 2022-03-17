package com.examu.upaxrest.repository;

import com.examu.upaxrest.models.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepo extends JpaRepository<Gender, Long> {

}
