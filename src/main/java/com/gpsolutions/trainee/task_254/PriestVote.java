package com.gpsolutions.trainee.task_254;

import java.util.*;

public class PriestVote {

    Integer countOfCo;

    private String getStatusCounty() {

        if (countOfCo >= 1 && countOfCo <= 5000) {
            return "";
        } else
            return "Enter current count of county (1<=N<=5000)";
    }

    private String getStatusCurrentPriest(String currentPriest) {

        Integer numOfCurrentPriest = Integer.valueOf(currentPriest);

        if (numOfCurrentPriest >= 1 && numOfCurrentPriest <= 200) {
            return "";
        } else
            return "Enter current number of current priest";
    }

    private String getStatusFuturePriest(String futurePriest) {

        Integer numOfFuturePriest = Integer.valueOf(futurePriest);

        if (numOfFuturePriest >= 1 && numOfFuturePriest <= 200) {
            return "";
        } else
            return "Enter current number of future priest (1<=M<=200)";
    }

    public ArrayList<String> enterVote(ArrayList<String> inputData) {

        ArrayList<String> result = new ArrayList<>();

        //initial "count of county" and check status
        countOfCo = Integer.valueOf(inputData.get(0));
        String tmpStatusCounty = this.getStatusCounty();
        if (!tmpStatusCounty.equals("")) {
            result.add(tmpStatusCounty);
        }


        //initial "numbers of current priests before event" and check status
        String[] list = inputData.get(1).split("\\s+");

        for (String tmp : list) {
            String tmpStatusCP = this.getStatusCurrentPriest(tmp);

            if (!tmpStatusCP.equals("")) {
                result.add(tmpStatusCP + " (1<=M<=200)");
            }
        }

        //initial array with priests
        countOfCo = list.length;
        String[] county = new String[countOfCo];

        for (int i = 0; i < countOfCo; i++) {
            county[i] = list[i];
        }

//check status for "current priests" and "future priests" in event
        for (int i = 0; i < county.length; i++) {

            Integer countFP = 3;
            while (countFP < inputData.size()) {

                String[] future = inputData.get(countFP).split("\\s+");
                String tmpStatusBeforeFP = this.getStatusCurrentPriest(future[0]);
                String tmpStatusFP = this.getStatusFuturePriest(future[1]);

                if (!tmpStatusBeforeFP.equals("")) {
                    result.add(tmpStatusBeforeFP + " before future priest value (1<=M<=200)");
                    return result;
                }

                if (!tmpStatusFP.equals("")) {
                    result.add(tmpStatusFP);
                    return result;
                }

                //changing numbers of priests
                if (county[i].equals(future[0])) {
                    county[i] = future[1];
                    break;
                }
                countFP++;

            }

        }
        String tmp = "";
        for (String val : county) {
            tmp += val + " ";
        }
        result.add(tmp);
        return result;
    }

}