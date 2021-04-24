package main.problems.java;

public class Nr1641 {

    private static final String[] vowels = new String[]{"a", "e", "i", "o", "u"};

    public static void main(String[] args) {
        Nr1641 nr1641 = new Nr1641();
        System.out.println(nr1641.countVowelStrings(2));
    }

    public int countVowelStrings(int n) {
        if (n == 0) {
            return 0;
        }

        return countStrings(n, 0, 0);
    }

    public int countStrings(int n, int start, int length) {
        if (n == length) {
            return 1;
        }

        int combinations = 0;
        for (int i = start; i < vowels.length; i++) {
            combinations += countStrings(n, i, length + 1);
        }
        return combinations;
    }
}
