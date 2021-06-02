package main.problems.java;

public class Nr1716 {
    public int totalMoney(int n) {
        int res = 0;
        int week = 1;
        for (int i = 0; i < n / 7; i++) {
            for (int j = 0; j < 7; j++) {
                res += i + j + 1;
            }
            week++;
        }
        for (int i = 0; i < n % 7; i++) {
            res += week + i;
        }
        return res;
    }
}
