package main.problems.java;

public class Nr1855 {
    public static void main(String[] args) {
        Nr1855 nr1855 = new Nr1855();
        System.out.println(
                nr1855.maxDistance(
                        new int[]{9820, 8937, 7936, 4855, 4830, 4122, 2327, 1342, 1167, 815, 414},
                        new int[]{9889, 9817, 9800, 9777, 9670, 9646, 9304, 8977, 8974, 8802, 8626, 8622, 8456}
                )
        );
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        int pointerNums2 = 0;
        int pointerNums1 = 0;
        for (; pointerNums2 < nums2.length && pointerNums1 < nums1.length; ) {
            while (pointerNums2 < nums2.length - 1
                    && nums1[pointerNums1] <= nums2[pointerNums2 + 1]) {
                pointerNums2++;
            }
            maxDistance = Math.max(pointerNums2 - pointerNums1, maxDistance);
            pointerNums2++;
            pointerNums1++;
        }
        return maxDistance;
    }
}
