package main.problems.java;

public class Nr1281 {
	public int subtractProductAndSum(int n) {
		int prod = 0;
		int sum = 0;
		if (n < 10) {
			sum = n;
			prod = n;
			return prod - sum;
		} else {
			int digit = n % 10;
			sum = digit;
			prod = digit;
			n /= 10;
		}
		while (n > 9) {
			int digit = n % 10;
			sum += digit;
			prod = prod * digit;
			n /= 10;
		}
		sum += n;
		prod = prod * n;

		return prod - sum;
	}
}
