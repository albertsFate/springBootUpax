package com.examu.upaxrest.models;

import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeT {
    private Long employee_id;
    private Date start_date;
    private Date end_date;
}
