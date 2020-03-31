package main.java.solutions;


/*
	Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

	Note: You may not slant the container and n is at least 2.
 */
public class Nr11 {

	//O(n), where n is the length of 'height'
	public int maxArea(int[] height) {
		int maxArea = 0;

		int front = 0;
		int back = height.length - 1;

		while (front < back) {
			maxArea = Math.max(maxArea, Math.min(height[front], height[back]) * (back - front));
			if (height[front] < height[back]) {
				front++;
			} else {
				back--;
			}
		}

		return maxArea;
	}

	/*
	Naive:

	public int maxArea(int[] height) {
		int maxArea = 0;

		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int smallerWall = Math.min(height[i], height[j]);
				maxArea = Math.max(maxArea, smallerWall * (j - i));
			}
		}

		return maxArea;
	}
	 */
}
