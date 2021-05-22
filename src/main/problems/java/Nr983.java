package main.problems.java;

public class Nr983 {
    public static void main(String[] args) {
        Nr983 nr983 = new Nr983();
        System.out.println(nr983.mincostTickets(
                new int[]{1, 4, 6, 7, 8, 20},
                new int[]{2, 7, 15}
                )
        );
    }

    public int mincostTickets(int[] days, int[] costs) {
        if (days.length == 1) {
            return Math.min(costs[0], Math.min(costs[1], costs[2]));
        }

        int[] minCost = new int[days[days.length - 1] + 1];
        minCost[days[0]] = costs[0];
        int nextDayIndex = 0;
        for (int i = days[0]; i < minCost.length; i++) {
            // Need ticket
            if (i == days[nextDayIndex]) {
                int oneDayTicket = minCost[i - Math.min(1, i)] + costs[0];
                int sevenDayTicket = minCost[i - Math.min(7, i)] + costs[1];
                int thirtyDayTicket = minCost[i - Math.min(30, i)] + costs[2];
                minCost[i] = Math.min(
                        Math.min(
                                oneDayTicket,
                                sevenDayTicket
                        ),
                        thirtyDayTicket
                );
                nextDayIndex++;
            } else {
                minCost[i] = minCost[i - 1];
            }
        }
        return minCost[days[days.length - 1]];
    }
}
