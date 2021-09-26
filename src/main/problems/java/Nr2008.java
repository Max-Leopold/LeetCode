package main.problems.java;

import java.util.Arrays;
import java.util.Comparator;

public class Nr2008 {

	public static void main(String[] args) {
		Nr2008 nr2008 = new Nr2008();
		System.out.println(nr2008.maxTaxiEarnings(
				20,
				new int[][]{
						{1, 6, 1},
						{3, 10, 2},
						{10, 12, 3},
						{11, 12, 2},
						{12, 15, 2},
						{13, 18, 1}
				}
		));
	}

	public long maxTaxiEarnings(int n, int[][] rides) {
		long[] maximumEarningsToPoint = new long[n + 1];
		Arrays.sort(rides, Comparator.comparingInt(arr -> arr[0]));

		int rideIndex = 0;
		for (int i = 1; i <= n; i++) {
			maximumEarningsToPoint[i] = Math.max(
					maximumEarningsToPoint[i],
					maximumEarningsToPoint[i - 1]
			);
			while (rideIndex < rides.length && rides[rideIndex][0] == i) {
				int[] ride = rides[rideIndex];
				long earningsFromRide = calculateEarnings(
						ride[0],
						ride[1],
						ride[2]
				);
				maximumEarningsToPoint[ride[1]] = Math.max(
						maximumEarningsToPoint[i] + earningsFromRide,
						maximumEarningsToPoint[ride[1]]
				);
				rideIndex++;
			}
		}

		return maximumEarningsToPoint[n];
	}

	private long calculateEarnings(long start, long end, long tip) {
		return end - start + tip;
	}
}
