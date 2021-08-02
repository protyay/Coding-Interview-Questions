import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Running TC - O(E Log V) SDE(Graph) problem
 */
public class Dijkstra_GFG {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        // System.out.println(adj);

        // We initialized a dist array
        int[] distCost = new int[V];

        Arrays.fill(distCost, Integer.MAX_VALUE);
        boolean[] visited = new boolean[V];

        // We relax each edge repeatedly
        Queue<Edge> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(Edge.of(S, 0));
        distCost[S] = 0;
        while (!pq.isEmpty()) {
            Edge currNode = pq.remove();
            // Mark the current edge as visited
            visited[currNode.to] = true;

            ArrayList<ArrayList<Integer>> edgeInfo = adj.get(currNode.to);
            for (ArrayList<Integer> dest : edgeInfo) {
                if (visited[dest.get(0)])
                    continue;
                if (distCost[dest.get(0)] > currNode.cost + dest.get(1)) {
                    // Update the distCost
                    distCost[dest.get(0)] = currNode.cost + dest.get(1);
                    pq.add(Edge.of(dest.get(0), distCost[dest.get(0)]));
                }
            }
        }
        return distCost;

    }
}

class Edge {
    int to;
    int cost;

    private Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    public static Edge of(int to, int cost) {
        if (cost < 0)
            throw new IllegalArgumentException("Dijkstra doesn't support negative weights");
        return new Edge(to, cost);
    }
}
/**
 * Write down and implement the brief overview of Implementing Djikstra's
 * algorithm.
 * 
 * We initialize a dist array and fill INFINITY values for all vertex except the
 * source.
 * 
 * Mark a node as visited only when we have 
 */
