package main.problems.java;

import java.util.HashSet;
import java.util.Set;

public class Nr771 {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewelsSet = new HashSet<>();
        for (Character jewel : jewels.toCharArray()) {
            jewelsSet.add(jewel);
        }
        int numberOfJewels = 0;
        for (Character stone : stones.toCharArray()) {
            if (jewelsSet.contains(stone)) numberOfJewels++;
        }
        return numberOfJewels;
    }
}
