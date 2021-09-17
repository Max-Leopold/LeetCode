package main.problems.java;

public class Nr1876 {
	public static void main(String[] args) {
		Nr1876 nr1876 = new Nr1876();
		nr1876.countGoodSubstrings("xyzzaz");
	}

	public int countGoodSubstrings(String s) {
		if (s.length() < 3) {
			return 0;
		}
		char[] window = new char[3];
		int replace = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			window[replace] = s.charAt(i);
			if (i > 1
					&& window[0] != window[1]
					&& window[1] != window[2]
					&& window[0] != window[2]
			) {
				count++;
			}
			replace = (replace + 1) % 3;
		}
		return count;
	}
}
