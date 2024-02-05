package com.example.collegescheduler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Assignment extends Event implements DateHolder {
    private LocalDate date;

    public Assignment(String title, String time_of_day, String days_of_week, String courseID, String date) {
        super(title, time_of_day, days_of_week, courseID);
        setDate(date);
    }

    public void setDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.date = LocalDate.parse(date, formatter);
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public String toString() {
        String s = super.toString();
        return String.format("%s\n%s\n-\n", s, date);
    }

}