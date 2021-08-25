package main.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Watermelon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int weight = sc.nextInt();
        if (weight % 2 == 0 && weight > 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
