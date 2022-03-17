package com.examu.upaxrest.events.responses;

import com.examu.upaxrest.models.Employee;
import lombok.Data;

import java.util.List;

@Data
public class ResponseEmployee {
    private List<Employee> employees;

    private boolean success;

    @Data
    public static class Response {
        private Long id;
        private boolean success;
    }
}
