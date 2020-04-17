package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nr22 {

	public static void main(String[] args) {
		Nr22 nr22 = new Nr22();
		System.out.println(Arrays.toString(nr22.generateParenthesis(4).toArray()));
	}

	public List<String> generateParenthesis(int n) {
		return generateAllParenthesis(n, 0, 0, "");
	}

	public List<String> generateAllParenthesis(int n, int alreadyOpened, int alreadyClosed, String currentString) {
		if (alreadyOpened == n && alreadyOpened == alreadyClosed) {
			ArrayList<String> list = new ArrayList<>();
			list.add(currentString);
			return list;
		}
		if (alreadyOpened == n) {
			return generateAllParenthesis(n, alreadyOpened, alreadyClosed + 1, currentString + ")");
		}

		if (alreadyOpened - alreadyClosed == 0) {
			return generateAllParenthesis(n, alreadyOpened + 1, alreadyClosed, currentString + "(");
		} else {
			List<String> returnList = generateAllParenthesis(n, alreadyOpened + 1, alreadyClosed, currentString + "(");
			returnList.addAll(generateAllParenthesis(n, alreadyOpened, alreadyClosed + 1, currentString + ")"));
			return returnList;
		}
	}
}
