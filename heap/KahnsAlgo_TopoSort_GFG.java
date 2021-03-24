import java.util.*;

public class KahnsAlgo_TopoSort_GFG {
    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int[] res = new int[V];
        int[] inDegree = new int[V];
        for (ArrayList<Integer> edges : adj) {
            for (int to : edges) {
                inDegree[to]++;
            }
        }
        //System.out.println(Arrays.toString(inDegree));

        Deque<Integer> nodes = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0)
                nodes.addLast(i);
        }
        int index = 0;
        while (!nodes.isEmpty()) {
            int currNode = nodes.removeFirst();
            // Adjust the edge count as one of the nodes are processed
            res[index++] = currNode;
            for (int to : adj.get(currNode)) {
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    nodes.addLast(to);
                }
            }
        }
        if (index != V) {
            System.out.println("Cycle detected. Invalid graph");
        }
        return res;
    }

    public static void main(String[] args) {
        KahnsAlgo_TopoSort_GFG kGfg = new KahnsAlgo_TopoSort_GFG();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int V = 6;
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        adjList.get(1).add(3);
        adjList.get(2).add(3);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(5).add(0);
        adjList.get(5).add(2);

        int[] ans = kGfg.topoSort(V, adjList);
        System.out.println(Arrays.toString(ans));
    }
}
