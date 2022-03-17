package com.examu.upaxrest.repository;

import com.examu.upaxrest.models.Employee;
import com.examu.upaxrest.models.Hour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface HourRepo extends JpaRepository<Hour, Long> {

    @Query("SELECT SUM(h.worked_hours) FROM Hour h where h.employee.id=?1 and h.date Between ?2 and ?3 ")
    Integer countHour(Long id, Date start_date, Date end_date);
}
