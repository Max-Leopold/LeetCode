package main.problems.java;

public class Nr1155 {

    public static void main(String[] args) {
        Nr1155 nr1155 = new Nr1155();
        System.out.println(nr1155.numRollsToTarget(10, 20, 100));
    }

    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) {
            return 0;
        }

        int[][] diceMatrix = new int[d][target];
        numRollsToTarget(diceMatrix, d, f, target);
        return getFromDiceMatrix(diceMatrix, d, target);
    }

    private int numRollsToTarget(int[][] diceMatrix, int d, int f, int target) {
        if (target <= 0 || target < d || target > d * f) {
            return 0;
        }

        if (getFromDiceMatrix(diceMatrix, d, target) != 0) {
            return getFromDiceMatrix(diceMatrix, d, target);
        }

        if (d == 1) {
            return insertIntoDiceMatrix(diceMatrix, d, target, 1);
        }

        int possibilities = 0;
        for (int i = 1; i <= f; i++) {
            possibilities += numRollsToTarget(diceMatrix, d - 1, f, target - i);
            possibilities %= 1000000007;
        }
        return insertIntoDiceMatrix(diceMatrix, d, target, possibilities);
    }

    private int getFromDiceMatrix(int[][] diceMatrix, int dices, int target) {
        if (dices < 1 || target < 1) {
            System.out.println("Hello");
        }
        return diceMatrix[dices - 1][target - 1];
    }

    private int insertIntoDiceMatrix(int[][] diceMatrix, int dices, int target, int value) {
        diceMatrix[dices - 1][target - 1] = value;
        return value;
    }
}
