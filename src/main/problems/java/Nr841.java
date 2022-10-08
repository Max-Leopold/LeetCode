package main.problems.java;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Nr841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> toVisit = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        toVisit.offer(0);

        while (!toVisit.isEmpty()) {
            int nextVisit = toVisit.poll();
            visited.add(nextVisit);

            for (Integer newRoom : rooms.get(nextVisit)) {
                if (!visited.contains(newRoom)) toVisit.offer(newRoom);
            }
        }

        return visited.size() == rooms.size();
    }
}
