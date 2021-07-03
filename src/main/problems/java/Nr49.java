package main.problems.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Nr49 {

    public static void main(String[] args) {
        Nr49 nr49 = new Nr49();
        System.out.println(nr49.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        ));

        System.out.println(
                new int[]{1, 2} == new int[]{1, 2}
        );
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<Id, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String currentString = strs[i];
            Id id = new Id();
            for (char c : currentString.toCharArray()) {
                id.addChar(c);
            }

            if (map.containsKey(id)) {
                map.get(id).add(currentString);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(currentString);
                map.put(id, newList);
            }
        }

        return new ArrayList<>(map.values());
    }

    private class Id {
        private final int[] id = new int[26];

        public void addChar(char c) {
            id[c - 'a']++;
        }

        public int[] getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id id1 = (Id) o;
            return Arrays.equals(id, id1.id);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(id);
        }
    }
}
