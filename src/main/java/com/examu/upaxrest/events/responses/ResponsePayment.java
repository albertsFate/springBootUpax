package com.examu.upaxrest.events.responses;

import lombok.Data;

@Data
public class ResponsePayment {
    private Double payment;
    private boolean success;
}
