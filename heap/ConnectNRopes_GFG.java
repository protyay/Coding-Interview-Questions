import java.util.*;

public class ConnectNRopes_GFG {
    long minCost(long arr[], int n) {
        // your code here
        Queue<Long> minH = new PriorityQueue<>();
        for (long rope : arr) {
            minH.add(rope);
        }
        long cost = 0;
        while (!minH.isEmpty() && minH.size() > 1) {
            long currCost = minH.poll() + minH.poll();
            minH.add(currCost);
            cost += currCost;
        }
        return cost;
    }

}
