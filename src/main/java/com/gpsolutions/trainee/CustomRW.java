package com.gpsolutions.trainee;

import java.io.*;
import java.util.ArrayList;

//Custom reader and writer
public class CustomRW {
   private String inputPath = null;
    String outputPath = null;

    {
        try {
            String path = System.getProperty("user.dir") +
                    File.separator + "src" + File.separator + "main" +
                    File.separator + "resources" + File.separator;
            inputPath = path + "input.txt";
            outputPath = path + "output.txt";
        } catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<String> read() {

        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath))) {
            String tmp = null;
            while ((tmp = reader.readLine()) != null) {
                result.add(tmp);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void write(ArrayList<String> output) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            for (String tmp : output) {
                writer.write(tmp+"\n");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
