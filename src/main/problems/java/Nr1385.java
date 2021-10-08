package main.problems.java;

public class Nr1385 {

	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int distanceValue = 0;

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (Math.abs(arr1[i] - arr2[j]) <= d) {
					distanceValue++;
					break;
				}
			}
		}
		return arr1.length - distanceValue;
	}
}
