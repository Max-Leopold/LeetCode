package main.problems.java;

import java.util.HashMap;

public class Nr1726 {

    public static void main(String[] args) {
        Nr1726 nr1726 = new Nr1726();
        System.out.println(nr1726.tupleSameProduct(new int[]{2, 3, 4, 6, 8, 12}));
    }

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> resultTupleAmountMap = new HashMap<>();
        int validTuples = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int res = nums[i] * nums[j];
                if (resultTupleAmountMap.containsKey(res)) {
                    validTuples += (resultTupleAmountMap.get(res) * 8);
                    resultTupleAmountMap.put(res, resultTupleAmountMap.get(res) + 1);
                } else {
                    resultTupleAmountMap.put(res, 1);
                }
            }
        }
        return validTuples;
    }
}
