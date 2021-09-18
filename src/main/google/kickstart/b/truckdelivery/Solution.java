package main.google.kickstart.b.truckdelivery;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int cases = in.nextInt();
		for (int i = 0; i < cases; i++) {
			int n = in.nextInt();
			int q = in.nextInt();
			Node[] cities = new Node[n];
			for (int j = 0; j < cities.length; j++) {
				cities[j] = new Node();
			}
			for (int j = 0; j < n - 1; j++) {
				int x = in.nextInt();
				int y = in.nextInt();
				long l = in.nextLong();
				long a = in.nextLong();
				x--;
				y--;

				cities[x].roads.add(new Road(y, l, a));
				cities[y].roads.add(new Road(x, l, a));
			}

			StringBuilder sb = new StringBuilder(q * 2);
			for (int j = 0; j < q; j++) {
				int startingCity = in.nextInt();
				int load = in.nextInt();
				long sol = solve(cities, startingCity - 1, load);
				sb.append(sol);
				sb.append(" ");
			}
			System.out.println("Case #" + (i + 1) + ": " + sb.toString().trim());
		}
	}

	private static long solve(Node[] cities, int startingCity, int load) {
		List<Long> tollCharges = dfs(
				cities,
				startingCity,
				new boolean[cities.length],
				load
		);
		return gcd(tollCharges);
	}

	private static List<Long> dfs(Node[] cities, int currentCity, boolean[] visited, int load) {
		if (currentCity == 0) {
			return new ArrayList<>();
		}

		Node currentCityNode = cities[currentCity];
		visited[currentCity] = true;
		for (Road road : currentCityNode.roads) {
			if (!visited[road.dest]) {
				List<Long> tollCharges = dfs(cities, road.dest, visited, load);
				if (tollCharges != null) {
					if (road.loadLimit <= load) {
						tollCharges.add(road.tollCharge);
					}
					return tollCharges;
				}
			}
		}
		return null;
	}

	private static long gcd(List<Long> integerList) {
		long res = 0;
		for (Long elem : integerList) {
			res = gcd(res, elem);
			if (res == 1) {
				return res;
			}
		}
		return res;
	}

	private static long gcd(long a, long b) {
		if (a == 0) {
			return b;
		}
		return gcd(b % a, a);
	}

	private static class Node {
		private final Set<Road> roads = new HashSet<>();
	}

	private static class Road {
		private final int dest;
		private final long loadLimit;
		private final long tollCharge;

		public Road(int dest, long loadLimit, long tollCharge) {
			this.dest = dest;
			this.loadLimit = loadLimit;
			this.tollCharge = tollCharge;
		}
	}
}
