package com.examu.upaxrest.controllers;

import com.examu.upaxrest.events.request.RequestEmployee;
import com.examu.upaxrest.models.Employee;
import com.examu.upaxrest.models.Job;
import com.examu.upaxrest.events.responses.ResponseEmployee;
import com.examu.upaxrest.service.EmployeeService;
import com.examu.upaxrest.service.GenderService;
import com.examu.upaxrest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeController {

    @Autowired
    private EmployeeService employeService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private JobService jobService;

    @GetMapping
    public  ResponseEntity <List<Employee>> getAllEmployee(){
        List <Employee> employee = new ArrayList<>();
        employee = employeService.getAllEmployee();
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseEmployee.Response> save(@RequestBody RequestEmployee request) {
        System.out.println(request);
        ResponseEmployee.Response response = new ResponseEmployee.Response();
        Employee newEmployee = employeService.createEmployee(request);
        System.out.println(newEmployee);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

      /*  if (obtenerAnios(request.getBirthdate()) > 17 && (employeService.findByNameAndLastName(request.getName(), request.getLastName())).size() < 1 && null != genderService.getGender(request.getGender().getId()) && null != jobService.getJob(request.getJob().getId())) {
            Employee newEmployee = employeService.createEmployee(request);
            System.out.println(newEmployee);
            response.setId(newEmployee.getId());
            response.setSuccess(true);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            response.setSuccess(false);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }*/
    }

    @PostMapping("/jobs")
    public ResponseEntity<ResponseEmployee> listEmployeeByJob(@RequestBody Job job){
        ResponseEmployee responseEmployee = new ResponseEmployee();
        if(null != job.getId()) {
            System.out.println(job);

            if (null != jobService.getJob(job.getId())) {
                responseEmployee.setEmployees(employeService.findByJob(Job.builder().id(job.getId()).build()));
                responseEmployee.setSuccess(true);
                return ResponseEntity.ok(responseEmployee);
            } else
                responseEmployee.setSuccess(false);
            return ResponseEntity.ok(responseEmployee);
        }else {
            System.out.println("Trabajo no encontrado");
            return null;
        }
    }

    public static int obtenerAnios(Date birthday) {
        LocalDate today = LocalDate.now();
        int year2 = today.getYear();
        int month2 = today.getMonthValue();
        int day2 = today.getDayOfMonth();

        Calendar b = getCalendar(birthday);
        int day = b.get(Calendar.DATE) + 1;
        int month = b.get(Calendar.MONTH) + 1;
        int year = b.get(Calendar.YEAR);

        int diference = year2 - year;
        if (month > month2 || (month == month2 && day > day2)){
            diference--;
        }
        return diference;
    }

    public static Calendar getCalendar(Date date){
        Calendar calendar = Calendar.getInstance(Locale.US);
        calendar.setTime(date);
        return calendar;
    }
}
