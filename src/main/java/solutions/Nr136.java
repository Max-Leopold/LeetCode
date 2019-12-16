package solutions;

public class Nr136 {

    public static void main(String[] args) {
        Nr136 nr136 = new Nr136();
        nr136.singleNumber(new int[]{1, 3, 4, 5, 4, 3, 1});
    }

    public int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
