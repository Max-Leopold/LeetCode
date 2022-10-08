package main.problems.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Nr547 {
    public int findCircleNum(int[][] isConnected) {
        int[] groups = new int[isConnected.length];
        for (int i = 0; i < groups.length; i++) {
            groups[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 0) continue;

                union(i, j, groups);
            }
        }

        Set<Integer> provinces = new HashSet<>();
        for (int group : groups) {
            provinces.add(find(group, groups));
        }

        return provinces.size();
    }

    private int find(int a, int[] groups) {
        if (a == groups[a]) {
            return a;
        }

        groups[a] = find(groups[a], groups);
        return groups[a];
    }

    private void union(int a, int b, int[] groups) {
        int groupA = find(a, groups);
        int groupB = find(b, groups);

        groups[groupB] = groupA;
    }
}
