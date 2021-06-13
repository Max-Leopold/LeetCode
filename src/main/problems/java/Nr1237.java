package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import main.util.java.CustomFunction;

public class Nr1237 {

    public static void main(String[] args) {
        Nr1237 nr1237 = new Nr1237();
        System.out.println(Arrays.deepToString(nr1237.findSolution((x, y) -> x + y, 5).toArray()));
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> answers = new ArrayList<>();

        int x = 1000;
        int y = 1;
        while (true) {
            if (x < 1) {
                break;
            }
            if (y > 1000) {
                break;
            }
            int shouldBe = binarySearch(customfunction, 1, x, y, z);
            int res = customfunction.f(shouldBe, y);
            x = shouldBe;
            if (res == z) {
                List<Integer> newAnswer = new ArrayList<>();
                newAnswer.add(x);
                newAnswer.add(y);
                answers.add(newAnswer);
            }
            y++;
        }
        return answers;
    }

    private int binarySearch(CustomFunction customFunction, int low, int high, int y, int z) {
        if (low >= high) {
            return low;
        }
        int pivot = low + (high - low + 1) / 2;
        int res = customFunction.f(pivot, y);
        if (res == z) {
            return pivot;
        } else if (res < z) {
            return binarySearch(customFunction, pivot + 1, high, y, z);
        } else {
            return binarySearch(customFunction, low, pivot - 1, y, z);
        }
    }
}
