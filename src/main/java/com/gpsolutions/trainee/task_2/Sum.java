package com.gpsolutions.trainee.task_2;

public class Sum {

    public String getSum(String input) {
        Integer res = 0;
        Integer value = Integer.valueOf(input);
        if (value <= 10000) {
            for (int i = 1; i <= value; i++) {
                res += i;
            }
            return res.toString();
        } else return "Enter current number (number<=10000)";

    }
}
