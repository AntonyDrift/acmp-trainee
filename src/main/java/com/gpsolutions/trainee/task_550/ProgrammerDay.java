package com.gpsolutions.trainee.task_550;

public class ProgrammerDay {

    private boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    public String getDate(String year) {
        Integer value = Integer.valueOf(year);
        if (value > 0 && value < 1000) {
            if (isLeapYear(value)) {
                return "12/09/" + year;
            } else return "13/09/" + year;
        } else return "Enter current year (0<year<9999)";
    }
    }
