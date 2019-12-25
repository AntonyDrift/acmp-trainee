package com.gpsolutions.trainee.task_58;

import java.util.ArrayList;

public class CuteTable {

    private Integer countTables = null; //1..10
    private Integer countRowN = null;//n>=1
    private Integer countColumnM = null;//m<=100

    private boolean flagTables = false;
    private boolean flagRowN = false;
    private boolean flagColumnM = false;

    public ArrayList<String> getResult(ArrayList<String> inputData) {

        this.initData(inputData);

        ArrayList<String> result = new ArrayList<>();
        String msg = this.getMessage();

        if (msg.equals("")) {
            //TRUE VALUES
            String[] tmpTable = new String[countRowN];

            int positionInputData = 2;

            while (positionInputData < inputData.size()) {

                int countRowTable = 0;

                while (countRowTable < countRowN) {

                    tmpTable[countRowTable] = inputData.get(countRowTable + positionInputData);
                    countRowTable++;
                }

                result.add(this.isCuteTable(tmpTable));
                positionInputData += countRowTable;
            }
        } else {
            //FALSE VALUE
            result.add(msg);
        }

        return result;
    }

    private void initData(ArrayList<String> input) {

        countTables = Integer.valueOf(input.get(0));
        String[] countsNM = input.get(1).split("\\s+");
        countRowN = Integer.valueOf(countsNM[0]);
        countColumnM = Integer.valueOf(countsNM[1]);
    }

    private String getMessage() {

        boolean[] status = this.getStatus();
        String msg = "";
        for (int i = 0; i < status.length; i++) {
            if (!status[i]) {
                switch (i) {
                    case 0:
                        msg += "Enter current count of tables (1<=t<=10);\n";
                        break;
                    case 1:
                        msg += "Enter current count of rows (n>=1);\n";
                        break;
                    case 2:
                        msg += "Enter current count of columns (0<=m<=100)";
                        break;
                }
            }
        }
        return msg;
    }

    private boolean[] getStatus() {

        flagTables = countTables >= 1 && countTables <= 10;
        flagRowN = countRowN >= 1;
        flagColumnM = countColumnM <= 100 && countColumnM >= 0;
        return new boolean[]{flagTables, flagRowN, flagColumnM};
    }

    //input data for draw each table
    private Integer[][] drawTable(String[] inputRowsTable) {

        Integer[][] table = new Integer[countRowN][countColumnM];

        for (int n = 0; n < countRowN; n++) {
            String[] tmp = inputRowsTable[n].split("\\s+");

            for (int m = 0; m < countColumnM; m++) {
                table[n][m] = Integer.valueOf(tmp[m]);
            }
        }
        return table;
    }

    //input data for each table
    private String isCuteTable(String[] inputRowsTable) {

        Integer[][] table = this.drawTable(inputRowsTable);

        for (int n = 0; n < table.length - 1; n++) {
            for (int m = 0; m < table[0].length - 1; m++) {

                if (n < table.length - 2 && m < table.length - 2) {
                    if (table[n][m] + table[n][m + 1] + table[n + 1][m] + table[n + 1][m + 1] % 4 == 0) {
                        return "NO";
                    }
                }
            }
        }
        return "YES";
    }


}

