package main.problems.java;

public class Nr38 {

    public static void main(String[] args) {
        Nr38 nr38 = new Nr38();
        System.out.println(
                nr38.countAndSay(4)
        );
    }

    public String countAndSay(int n) {
        String currentString = "1";
        for (int i = 1; i < n; i++) {
            currentString = countAndSay(
                    currentString,
                    1,
                    currentString.charAt(0),
                    1,
                    new StringBuilder()
            ).toString();
        }
        return currentString;
    }

    public StringBuilder countAndSay(
            String n,
            int currentIndex,
            char lastDigit,
            int countOfCurrentDigit,
            StringBuilder sb
    ) {
        if (currentIndex >= n.length()) {
            sb.append(countOfCurrentDigit);
            sb.append(lastDigit);
            return sb;
        }
        char firstDigit = n.charAt(currentIndex);
        if (firstDigit != lastDigit) {
            sb.append(countOfCurrentDigit);
            sb.append(lastDigit);
            return countAndSay(
                    n,
                    currentIndex + 1,
                    firstDigit,
                    1,
                    sb
            );
        } else {
            return countAndSay(
                    n,
                    currentIndex + 1,
                    firstDigit,
                    countOfCurrentDigit + 1,
                    sb
            );
        }
    }
}
