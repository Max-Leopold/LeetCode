package main.problems.java;

import java.util.Arrays;

public class Nr6 {

    public static void main(String[] args) {
        Nr6 nr6 = new Nr6();
        System.out.println(nr6.convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        IntWave intWave = new IntWave(0, numRows - 1);
        StringBuffer[] rows = new StringBuffer[numRows];
        Arrays.setAll(rows, x -> new StringBuffer());
        for (int i = 0; i < s.length(); i++) {
            rows[intWave.get()].append(s.charAt(i));
        }

        for (int i = 1; i < rows.length; i++) {
            rows[0].append(rows[i]);
        }

        return rows[0].toString();
    }

    public class IntWave {
        private final int upperLevel;
        private final int lowerLevel;

        private boolean goingUp = true;
        private int currentNum;

        public IntWave(int lowerLevel, int upperLevel) {
            this.upperLevel = upperLevel;
            this.lowerLevel = lowerLevel;

            currentNum = lowerLevel;
        }

        public int get() {
            if (lowerLevel == upperLevel) {
                return lowerLevel;
            }

            int returnValue = currentNum;
            if (goingUp) {
                if (currentNum == upperLevel) {
                    currentNum--;
                    goingUp = false;
                } else {
                    currentNum++;
                }
            } else {
                if (currentNum == lowerLevel) {
                    currentNum++;
                    goingUp = true;
                } else {
                    currentNum--;
                }
            }

            return returnValue;
        }


    }
}
