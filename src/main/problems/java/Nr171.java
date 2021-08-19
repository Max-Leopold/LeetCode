package main.problems.java;

public class Nr171 {
    public int titleToNumber(String columnTitle) {
        int column = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            column *= 26;
            column += (columnTitle.charAt(i) - 'A' + 1);
        }
        return column;
    }
}
