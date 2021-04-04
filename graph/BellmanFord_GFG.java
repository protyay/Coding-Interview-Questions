import java.util.Arrays;

public class BellmanFord_GFG {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        // code here
        // We need to relax each Edge V-1 times
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        // Choose the starting node as zero
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                int from = edge[0], to = edge[1], wt = edge[2];
                if (dist[from] + wt < dist[to])
                    dist[to] = dist[from] + wt;
            }
        }
       
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], wt = edge[2];
            if (dist[from] + wt < dist[to])
                return 1;   
        }

        return 0;
    }
}
