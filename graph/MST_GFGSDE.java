import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MST_GFGSDE {
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        // Add your code here
        // [[[1, 5], [2, 1]], [[0, 5], [2, 3]], [[1, 3], [0, 1]]]
        // System.out.println(adj);
        int mstCost = 0;
        // For MST to complete, the total edge will be V - 1
        int visitedEdge = 0;
        boolean[] visited = new boolean[V];
        Queue<Triplet> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        // Our source NODE is 0
        addEdges(0, adj.get(0), pq, visited);

        while (!pq.isEmpty() && visitedEdge < V - 1) {
            Triplet currNode = pq.remove();
            int toNode = currNode.to;

            if (visited[toNode])
                continue;

            visited[currNode.start] = true;
            visitedEdge++;
            mstCost += currNode.cost;

            addEdges(toNode, adj.get(toNode), pq, visited);
        }
        if (visitedEdge != V - 1)
            return -1;
        return mstCost;

    }

    private static void addEdges(int sourceNode, ArrayList<ArrayList<Integer>> outEdges, Queue<Triplet> pq,
            boolean[] visited) {
        for (ArrayList<Integer> edge : outEdges) {
            if (visited[edge.get(0)])
                continue;
            Triplet nodeInfo = new Triplet(sourceNode, edge.get(0), edge.get(1));
            pq.add(nodeInfo);
        }
    }

    public static void main(String[] args) {
        int V = 3;
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<ArrayList<Integer>>());
        }

        ArrayList<ArrayList<Integer>> edgeCost0 = adjList.get(0);
        edgeCost0.add(new ArrayList<>(Arrays.asList(1, 5)));
        edgeCost0.add(new ArrayList<>(Arrays.asList(2, 1)));

        ArrayList<ArrayList<Integer>> edgeCost1 = adjList.get(1);
        edgeCost1.add(new ArrayList<>(Arrays.asList(0, 5)));
        edgeCost1.add(new ArrayList<>(Arrays.asList(2, 3)));

        ArrayList<ArrayList<Integer>> edgeCost2 = adjList.get(2);
        edgeCost2.add(new ArrayList<>(Arrays.asList(0, 1)));
        edgeCost2.add(new ArrayList<>(Arrays.asList(1, 3)));

        int cost = MST_GFGSDE.spanningTree(3, adjList);
        System.out.println("MST cost =" + cost);

    }
}

class Triplet {
    int start;
    int to;
    int cost;

    Triplet(int start, int to, int cost) {
        this.start = start;
        this.to = to;
        this.cost = cost;
    }
}
