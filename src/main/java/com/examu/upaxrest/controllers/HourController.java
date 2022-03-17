package com.examu.upaxrest.controllers;

import com.examu.upaxrest.models.EmployeeT;
import com.examu.upaxrest.models.Hour;
import com.examu.upaxrest.events.responses.ResponseHourT;
import com.examu.upaxrest.events.responses.ResponsePayment;
import com.examu.upaxrest.service.EmployeeService;
import com.examu.upaxrest.service.HourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.text.SimpleDateFormat;

@RestController
@RequestMapping(value = "/hour")
public class HourController {

    @Autowired
    private HourService hoursService;

    @Autowired
    private EmployeeService employeService;


    @PostMapping("/save")
    public ResponseEntity<Hour> save(@RequestBody Hour hour){
        Hour newHour = hoursService.createHours(hour);
        return ResponseEntity.status(HttpStatus.CREATED).body(newHour);
    }

    @PostMapping("/count")
    public ResponseEntity<ResponseHourT> contar(@RequestBody EmployeeT employeeT){
        ResponseHourT responseHourT = new ResponseHourT();
        Integer hours;
        System.out.println(employeeT);
        if(null != employeService.getEmployee(employeeT.getEmployee_id()) && employeeT.getStart_date().before(employeeT.getEnd_date()) ){
            hours  = hoursService.countHours(employeeT.getEmployee_id(),
                    employeeT.getStart_date(),
                    employeeT.getEnd_date());
            if (null!=hours){
                responseHourT.setTotal_worked_hours(hours);
                responseHourT.setSuccess(true);
            }else
                responseHourT.setSuccess(false);
            return ResponseEntity.ok(responseHourT);
        }else
            responseHourT.setSuccess(false);
        return ResponseEntity.ok(responseHourT);
    }


    @PostMapping("/amount")
    public ResponseEntity<ResponsePayment> sumar(@RequestBody EmployeeT employeeT){
      /*  System.out.println(employeeT);
        ResponsePayment pagos = new ResponsePayment();
        if(null != employeService.getEmployee(employeeT.getEmployee_id()) && employeeT.getStart_date().before(employeeT.getEnd_date()) ){
            Integer horas = hoursService.countHours(employeeT.getEmployee_id(), employeeT.getStart_date(), employeeT.getEnd_date());
            Double salary = employeService.getEmployee(employeeT.getEmployee_id()).getJob().getSalary();
            if (null!= horas && null != salary) {
                pagos.setPayment(horas * salary);
                pagos.setSuccess(true);
            }else
                pagos.setSuccess(false);
            return ResponseEntity.ok(pagos);
        }else
            pagos.setSuccess(false);
        return ResponseEntity.ok(pagos);*/
        return null;
    }


    public String FormatDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(sdf.format(date));
        return sdf.format(date);
    }


}
