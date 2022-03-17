package com.examu.upaxrest.repository;

import com.examu.upaxrest.models.Employee;
import com.examu.upaxrest.models.Gender;
import com.examu.upaxrest.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findByJob (Job job);

    @Query("Select e FROM Employee e where e.name=?1 and e.lastName=?2")
    List <Employee> findByNameAndLastName(String name, String lastName);

    List<Employee> findByGender(Gender gender);

}
