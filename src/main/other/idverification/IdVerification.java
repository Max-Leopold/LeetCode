package main.other.idverification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IdVerification {

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		while (true) {
			String idCode = sc.nextLine();
			boolean isValidId = isValidId(idCode);
			if (isValidId) {
				System.out.println("PASS");
			} else {
				System.out.println("INVESTIGATE");
			}
		}
	}

	protected static boolean isValidId(String s) {
		if (s == null) {
			return false;
		}
		if (s.length() < 13) {
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (i < 4) {
				if (!Character.isLetter(c)) {
					return false;
				}
			} else {
				if (!Character.isDigit(c)) {
					return false;
				}
			}
		}

		String initials = s.substring(0, 4);
		String numericPart = s.substring(4, s.length() - 1);
		Integer verificationDigit = Integer.parseInt(s.substring(s.length() - 1));

		int o = 0;
		int e = 0;
		for (int i = 0; i < numericPart.length(); i++) {
			if (i % 2 == 0) {
				e += Character.getNumericValue(numericPart.charAt(i));
			} else {
				o += Character.getNumericValue(numericPart.charAt(i));
			}
		}

		int v = Math.abs(o - e) % 10;
		return v == verificationDigit;
	}
}
