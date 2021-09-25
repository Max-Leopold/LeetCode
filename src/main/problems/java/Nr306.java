package main.problems.java;

public class Nr306 {
	public boolean isAdditiveNumber(String num) {
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(0) == '0' && i > 0) {
				return false;
			}
			for (int j = i + 1; j < num.length(); j++) {
				if (num.charAt(i + 1) == '0' && j - i > 1) {
					break;
				}

				if (isAdditiveNumber(
						num.substring(j + 1),
						Long.parseLong(num.substring(0, i + 1)),
						Long.parseLong(num.substring(i + 1, j + 1))
				)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean isAdditiveNumber(
			String num,
			long firstNum,
			long secondNum
	) {
		String sum = String.valueOf(firstNum + secondNum);
		if (!num.startsWith(sum)) {
			return false;
		}
		if (num.length() == sum.length()) {
			return true;
		}
		return isAdditiveNumber(num.substring(sum.length()), secondNum, firstNum + secondNum);
	}
}
