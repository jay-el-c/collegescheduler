package com.example.collegescheduler;

import java.util.*;
import java.io.*;

public class Storage implements Serializable {
    private ArrayList<Assignment> assignments;
    private ArrayList<Exam> exams;
    private ArrayList<Class> classes;

    public Storage() {
        assignments = new ArrayList<Assignment>();
        exams = new ArrayList<Exam>();
        classes = new ArrayList<Class>();
    }

    //returns arraylist of Events
    public ArrayList<DateHolder> sortExamsAssignmentsByDate() {
        ArrayList<DateHolder> mergedList = new ArrayList<DateHolder>(exams);
        mergedList.addAll(assignments);
        Collections.sort(mergedList, new DateHolderComparator());
        return mergedList;
    }

    public HashMap<String, ArrayList<Event>> getWeeklySchedule() {
        //returns a hashmap with days of the week as keys and arraylist containing events that day, sorted by time
        HashMap<String, ArrayList<Event>> weeklySchedule = new HashMap<String, ArrayList<Event>>();
        weeklySchedule.put("monday", new ArrayList<Event>());
        weeklySchedule.put("tuesday", new ArrayList<Event>());
        weeklySchedule.put("wednesday", new ArrayList<Event>());
        weeklySchedule.put("thursday", new ArrayList<Event>());
        weeklySchedule.put("friday", new ArrayList<Event>());
        weeklySchedule.put("saturday", new ArrayList<Event>());
        weeklySchedule.put("sunday", new ArrayList<Event>());
        Collections.sort(assignments, new DateHolderComparator());
        Collections.sort(exams, new DateHolderComparator());
        for (Class c : classes) {
            String[] days = c.getDaysOfWeek().split(", ");
            for (String d : days) {
                d = d.strip().toLowerCase();
                if (weeklySchedule.get(d) != null) {
                    weeklySchedule.get(d).add(c);
                }
            }
        }
        for (Exam e : exams) {
            String[] days = e.getDaysOfWeek().split(", ");
            for (String d : days) {
                d = d.strip().toLowerCase();
                if (weeklySchedule.get(d) != null) {
                    weeklySchedule.get(d).add(e);
                }
            }
        }
        for (Assignment a : assignments) {
            String[] days = a.getDaysOfWeek().split(", ");
            for (String d : days) {
                d = d.strip().toLowerCase();
                if (weeklySchedule.get(d) != null) {
                    weeklySchedule.get(d).add(a);
                }
            }
        }
        return weeklySchedule;
    }

    public void addAssigment(Assignment a) {
        assignments.add(a);
    }

    public void addExam(Exam e) {
        exams.add(e);
    }

    public void addClass(Class c) {
        classes.add(c);
    }

    public void clear() {
        assignments = new ArrayList<Assignment>();
        exams = new ArrayList<Exam>();
        classes = new ArrayList<Class>();
    }

    public void store() {
        PrintWriter writer = null;
        try {
            String fileDir = "data.txt";
            File file = new File(fileDir);
            if (!file.exists()) {
                file.createNewFile();
            }
            writer = new PrintWriter(file, "UTF-8");
        } catch(IOException e) {
            e.printStackTrace();
        }
        String data = toString();
        writer.println(data);
        writer.close();
    }

    public void retrieve() {
        Scanner scan = null;
        try {
            String fileDir = "data.txt";
            File file = new File(fileDir);
            scan = new Scanner(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numAss = Integer.parseInt(scan.nextLine().split(">")[1]);
        for (int i = 0; i < numAss; i++) {
            String title = scan.nextLine();
            String time_of_day = scan.nextLine();
            String days_of_week = scan.nextLine();
            String courseID = scan.nextLine();
            String date = scan.nextLine();
            Assignment a = new Assignment(title, time_of_day, days_of_week, courseID, date);
            addAssigment(a);
            scan.nextLine();
        }
        int numExam = Integer.parseInt(scan.nextLine().split(">")[1]);
        for (int i = 0; i < numExam; i++) {
            String title = scan.nextLine();
            String time_of_day = scan.nextLine();
            String days_of_week = scan.nextLine();
            String courseID = scan.nextLine();
            String location = scan.nextLine();
            String date = scan.nextLine();
            Exam e = new Exam(title, time_of_day, days_of_week, courseID, location, date);
            addExam(e);
            scan.nextLine();
        }
        int numClass = Integer.parseInt(scan.nextLine().split(">")[1]);
        for (int i = 0; i < numClass; i++) {
            String title = scan.nextLine();
            String time_of_day = scan.nextLine();
            String days_of_week = scan.nextLine();
            String courseID = scan.nextLine();
            String location = scan.nextLine();
            String instructor = scan.nextLine();
            Class c = new Class(title, time_of_day, days_of_week, courseID, location, instructor);
            addClass(c);
            scan.nextLine();
        }
    }

    public String toString() {
        String data = String.format("<assignments>%d\n", assignments.size());
        for (Assignment a : assignments) {
            data += a;
        }
        data += String.format("<exams>%d\n", exams.size());
        for (Exam e : exams) {
            data += e;
        }
        data += String.format("<classes>%d\n", classes.size());
        for (Class c : classes) {
            data += c;
        }
        return data;
    }


}