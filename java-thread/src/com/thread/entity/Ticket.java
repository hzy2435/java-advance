package com.thread.entity;

import java.time.LocalDate;

public class Ticket {
    private Integer seatNo;
    private LocalDate date;
    private String startPlace;

    public Ticket(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public Integer getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(Integer seatNo) {
        this.seatNo = seatNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }
}
