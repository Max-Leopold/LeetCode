package main.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class WayTooLongWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int cases = sc.nextInt();
        for (int i = 0; i < cases; i++) {
            String word = sc.next();
            if (word.length() > 10) {
                System.out.println(word.charAt(0) + "" + (word.length() - 2) + "" + word.charAt(word.length() - 1));
            } else {
                System.out.println(word);
            }
        }
    }
}
