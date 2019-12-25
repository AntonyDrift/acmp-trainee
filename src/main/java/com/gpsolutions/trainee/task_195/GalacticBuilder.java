package com.gpsolutions.trainee.task_195;

import java.util.ArrayList;

public class GalacticBuilder {

    private Integer sumOfPanel;
    private Integer width;
    private Integer length;

    private boolean sumFlag;
    private boolean widthFlag;
    private boolean lengthFlag;

    private boolean[] getStatus() {

        sumFlag = sumOfPanel >= 1 && sumOfPanel <= 100;
        widthFlag = width >= 1 && width <= 100;
        lengthFlag = length >= 1 && length <= 100;
        return new boolean[]{sumFlag, widthFlag, lengthFlag};
    }

    private String getMessage() {

        boolean[] status = this.getStatus();
        String msg = "";
        for (int i = 0; i < status.length; i++) {
            if (!status[i]) {
                switch (i) {
                    case 0:
                        msg += "Enter current value amount of panels (1<=N<=100);\n";
                        break;
                    case 1:
                        msg += "Enter current value of width (1<=A<=100);\n";
                        break;
                    case 2:
                        msg += "Enter current value of length (1<=B<=100)";
                        break;
                }
            }
        }
        return msg;
    }

    private void initData(ArrayList<String> inputData) {

        String[] tmp = inputData.get(0).split("\\s+");
        sumOfPanel = Integer.valueOf(tmp[0]);
        width = Integer.valueOf(tmp[1]);
        length = Integer.valueOf(tmp[2]);
    }


    public String getAmount(ArrayList<String> inputData) {

        this.initData(inputData);
        String msg = this.getMessage();

        if (msg.equals("")) {
            return String.valueOf(width * length * sumOfPanel * 2);
        } else return msg;
    }


}
