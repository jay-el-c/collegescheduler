package com.example.collegescheduler;

import com.example.collegescheduler.DateHolder;

import java.util.Comparator;

public class DateHolderComparator implements Comparator<DateHolder> {
    @Override
    public int compare(DateHolder o1, DateHolder o2) {
        return o1.getLocalDate().compareTo(o2.getLocalDate());
    }
}