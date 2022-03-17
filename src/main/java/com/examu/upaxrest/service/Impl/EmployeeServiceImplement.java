package com.examu.upaxrest.service.Impl;

import com.examu.upaxrest.events.request.RequestEmployee;
import com.examu.upaxrest.models.Employee;
import com.examu.upaxrest.models.Gender;
import com.examu.upaxrest.models.Job;
import com.examu.upaxrest.repository.EmployeeRepo;
import com.examu.upaxrest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImplement implements EmployeeService {

    private final EmployeeRepo employeeRepo;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> findByJob(Job job) {
        return employeeRepo.findByJob(job);
    }

    @Override
    public List<Employee> findByGender(Gender gender) {
        return employeeRepo.findByGender(gender);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            return null;
        }
    }

    @Override
    public Employee createEmployee(RequestEmployee requestEmployee) {

        Employee employee = new Employee();
        employee.setId(requestEmployee.getId());
        employee.setName(requestEmployee.getName());
        employee.setLastName(requestEmployee.getLastName());
        employee.setBirthdate(requestEmployee.getBirthdate());
        employee.setGender(requestEmployee.getGender());
        employee.setJob(requestEmployee.getJob());

        System.out.println("REQUEST: " + requestEmployee);
        System.out.println("EMPLOYEE " + employee );

        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> findByNameAndLastName(String name, String lastName) {
        List<Employee> employee = new ArrayList<>();
        employee = employeeRepo.findByNameAndLastName(name, lastName);
        return employee;
    }
}
