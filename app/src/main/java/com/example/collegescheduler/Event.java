package com.example.collegescheduler;

public class Event {
    private String title;
    private String time_of_day;
    private String days_of_week;
    private String courseID;

    public Event(String title, String time_of_day, String days_of_week, String courseID) {
        this.title = title;
        this.time_of_day = time_of_day;
        this.days_of_week = days_of_week;
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public String getTimeOfDay() {
        return time_of_day;
    }

    public String getDaysOfWeek() {
        return days_of_week;
    }

    public String getCourseID() {
        return courseID;
    }

    public String toString() {
        return String.format("%s\n%s\n%s\n%s", title, time_of_day, days_of_week, courseID);
    }
}