import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
/** 
 * Running TC - O(E Log V)
*/
public class Dijkstra_GFG {
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        // System.out.println(adj);
        int[] distCost = new int[V];
        Arrays.fill(distCost, Integer.MAX_VALUE);
        Queue<Edge> minCost = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        boolean[] visited = new boolean[V];
        // Start graph exploration from the source edge
        Edge source = Edge.of(S,0);
        minCost.add(source);
        
        while(!minCost.isEmpty()) {
            int size = minCost.size();
            while(size-- > 0){
                Edge currEdge = minCost.remove();
                visited[currEdge.to] = true;
                if(distCost[currEdge.to] > currEdge.cost)
                    distCost[currEdge.to] = currEdge.cost;
                    
                // Start exploring the neighbours
                ArrayList<ArrayList<Integer>> edges = adj.get(currEdge.to);
                for(ArrayList<Integer> edge : edges){
                    if(visited[edge.get(0)]) continue;
                    minCost.add(Edge.of(edge.get(0), currEdge.cost + edge.get(1)));
                }
            }
        }
        return distCost;
        
    }
}
class Edge {
    int to;
    int cost;
    private Edge(int to, int cost){
        this.to = to;
        this.cost = cost;
    }
    public static Edge of(int to, int cost){
        if(cost < 0) throw new IllegalArgumentException("Dijkstra doesn't support negative weights");
        return new Edge(to, cost);
    }
}

