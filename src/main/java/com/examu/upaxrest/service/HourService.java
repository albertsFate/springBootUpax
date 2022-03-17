package com.examu.upaxrest.service;

import com.examu.upaxrest.models.Employee;
import com.examu.upaxrest.models.Hour;

import java.sql.Date;
import java.util.List;

public interface HourService {

    Hour createHours(Hour hours);
    Integer countHours( Long id, Date start_date,Date end_date);
}
