package main.problems.java;

public class Nr565 {

    public static void main(String[] args) {
        Nr565 nr565 = new Nr565();
        System.out.println(nr565.arrayNesting(new int[]{5, 4, 0, 3, 1, 6, 2}));
    }

    public int arrayNesting(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int length = 0;
            int currentIndex = i;
            while (nums[currentIndex] != -1) {
                int tmpIndex = currentIndex;
                currentIndex = nums[tmpIndex];
                nums[tmpIndex] = -1;
                length++;
            }
            maxLength = Math.max(length, maxLength);
        }

        return maxLength;
    }
}
