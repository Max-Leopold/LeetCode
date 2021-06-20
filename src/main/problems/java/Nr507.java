package main.problems.java;

public class Nr507 {
    public static void main(String[] args) {
        Nr507 nr507 = new Nr507();
        System.out.println(nr507.checkPerfectNumber(496));
    }

    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }

        int sum = 0;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;

                // If this is true i == Math.sqrt(num).
                // We have already added it with sum += 1 and don't want to add it again.
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        // Having to add 1 because every number is divisible by 1 and we start with 2 in the for loop.
        sum++;

        return sum == num;
    }
}
