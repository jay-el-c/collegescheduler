package com.example.collegescheduler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Exam extends Event implements DateHolder {
    private String location;
    private LocalDate date;

    public Exam(String title, String time_of_day, String days_of_week, String courseID, String location, String date) {
        super(title, time_of_day, days_of_week, courseID);
        this.location = location;
        setDate(date);
    }

    public String getLocation() {
        return location;
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
        return String.format("%s\n%s\n%s\n-\n", s, location, date);
    }


}