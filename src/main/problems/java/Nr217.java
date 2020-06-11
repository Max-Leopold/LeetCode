package main.problems.java;

import java.util.HashSet;

public class Nr217 {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> alreadySeen = new HashSet<>();
        for (int num : nums) {
            if (alreadySeen.contains(num)) {
                return true;
            }
            alreadySeen.add(num);
        }
        return false;
    }
}
