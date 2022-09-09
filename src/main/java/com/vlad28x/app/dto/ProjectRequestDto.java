package com.vlad28x.app.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ProjectRequestDto {

    private String name;
    private Long payment;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    private Long customerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPayment() {
        return payment;
    }

    public void setPayment(Long payment) {
        this.payment = payment;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
