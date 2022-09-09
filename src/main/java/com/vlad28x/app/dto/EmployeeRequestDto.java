package com.vlad28x.app.dto;

import com.vlad28x.app.entity.enums.Position;

import java.time.LocalDate;

public class EmployeeRequestDto {

    private Position position;
    private LocalDate hireDate;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }
}