package com.gpsolutions.trainee;

import com.gpsolutions.trainee.task_195.GalacticBuilder;
import com.gpsolutions.trainee.task_2.Sum;
import com.gpsolutions.trainee.task_254.PriestVote;
import com.gpsolutions.trainee.task_550.ProgrammerDay;
import com.gpsolutions.trainee.task_58.CuteTable;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {

        CustomRW rw = new CustomRW();

        Sum task2 = new Sum();
        ProgrammerDay task550 = new ProgrammerDay();
        CuteTable task58 = new CuteTable();
        GalacticBuilder task195 = new GalacticBuilder();
        PriestVote task254 = new PriestVote();

        ArrayList<String> input = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();

        try {
            String menu = "1. App \"Sum of integer numbers\";\n" +
                    "2. App \"Programmer Day\";\n" +
                    "3. App \"Is are cute table?\";\n" +
                    "4. App \"Galactic Builder\";\n" +
                    "5. App \"Priest Vote\";\n" +
                    "______________________________________\n" +
                    "Enter \"number\" and write values in \"input.txt\"!";
            System.out.println(menu);
            Scanner scanner = new Scanner(System.in);

            input = rw.read();


            switch (scanner.nextLine()) {
                //Sum numbers
                case "1":
                    output.add(task2.getSum(input.get(0)));
                    break;
                //Programmer Day
                case "2":
                    output.add(task550.getDate(input.get(0)));
                    break;
                //Cute Table
                case "3":
                    for (String result : task58.getResult(input)) {
                        output.add(result);
                    }
                    break;
                //Galactic Builder
                case "4":
                    output.add(task195.getAmount(input));
                    break;
                //Priest Vote
                case "5":
                    for (String result : task254.enterVote(input)) {
                        output.add(result);
                    }
                    break;
            }
            System.out.println("Checkout result into: " + rw.outputPath);
            rw.write(output);


        } catch (Exception ex) {
            output.add("Enter current value");
            rw.write(output);
        } finally {
            output.clear();
            input.clear();
        }
    }
}
