package main.problems.java;

public class Nr860 {
    public static void main(String[] args) {
        Nr860 nr860 = new Nr860();
        System.out.println(nr860.lemonadeChange(
                new int[]{5, 10, 20}
        ));
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            int diff = bills[i] - 5;
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                ten++;
            }
            if (diff == 0) {
                continue;
            } else if (diff == 5) {
                if (five > 0) {
                    five--;
                    continue;
                }
                return false;
            } else if (diff == 10) {
                if (ten > 0) {
                    ten--;
                    continue;
                }
                if (five > 1) {
                    five -= 2;
                    continue;
                }

                return false;
            } else if (diff == 15) {
                if (ten > 0) {
                    if (five > 0) {
                        ten--;
                        five--;
                        continue;
                    }
                }
                if (five > 2) {
                    five -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
