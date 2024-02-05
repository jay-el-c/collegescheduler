package com.example.collegescheduler;

public class Class extends Event {
    private String location;
    private String instructor;

    public Class(String title, String time_of_day, String days_of_week, String courseID, String location, String instructor) {
        super(title, time_of_day, days_of_week, courseID);
        this.location = location;
        this.instructor = instructor;
    }

    public String getLocation() {
        return location;
    }

    public String getInstructor() {
        return instructor;
    }

    public String toString() {
        String s = super.toString();
        return String.format("%s\n%s\n%s\n-\n", s, location, instructor);
    }
}