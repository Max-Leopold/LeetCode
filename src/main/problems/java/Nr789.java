package main.problems.java;

public class Nr789 {
	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		int myDistance = calculateManhattenDistance(0, 0, target[0], target[1]);
		System.out.println("My distance: " + myDistance);
		for (int i = 0; i < ghosts.length; i++) {
			int distance = calculateManhattenDistance(
					ghosts[i][0], ghosts[i][1],
					target[0], target[1]
			);
			System.out.println("Ghost Distance: " + distance);
			if (distance <= myDistance) {
				return false;
			}
		}
		return true;
	}

	private int calculateManhattenDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 + y2);
	}
}
