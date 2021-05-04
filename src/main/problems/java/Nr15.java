package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nr15 {

    public static void main(String[] args) {
        Nr15 nr15 = new Nr15();
        System.out.println(
                Arrays.deepToString(
                        nr15.threeSum(
                                new int[]{0, 0, 0, 0}
                        ).stream()
                                .map(List::toArray)
                                .toArray()
                )
        );
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int firstNum = nums[i];
            int head = i + 1;
            int tail = nums.length - 1;
            while (head < tail) {
                int res = firstNum + nums[head] + nums[tail];
                if (res == 0) {
                    returnList.add(Arrays.asList(firstNum, nums[head], nums[tail]));
                    head++;
                    while (head < tail && nums[head] == nums[head - 1]) head++;
                } else if (res > 0) {
                    tail--;
                } else {
                    head++;
                }
            }
        }

        return returnList;
    }
}
