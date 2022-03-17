package com.examu.upaxrest.service;

import com.examu.upaxrest.events.request.RequestEmployee;
import com.examu.upaxrest.models.Employee;
import com.examu.upaxrest.models.Gender;
import com.examu.upaxrest.models.Job;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    List<Employee> findByJob(Job job);
    List<Employee> findByGender(Gender gender);
    Employee getEmployee(Long id);
    Employee createEmployee ( RequestEmployee employee);
    List <Employee> findByNameAndLastName(String name, String lastName);
}
