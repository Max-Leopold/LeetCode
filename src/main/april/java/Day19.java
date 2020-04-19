package main.april.java;

public class Day19 {

	public static void main(String[] args) {
		Day19 day19 = new Day19();
		System.out.println(day19.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
	}

	public int search(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;

		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else hi = mid;
		}

		int pivot = lo;
		lo = 0;
		hi = nums.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int realMid = (mid + pivot) % nums.length;
			if (nums[realMid] == target) {
				return realMid;
			}
			if (nums[realMid] < target) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}

		return -1;
	}
}
