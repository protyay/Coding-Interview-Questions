import java.util.*;

public class StronglyConnComp_Kosaraju {
    Deque<Integer> nodes = new ArrayDeque<>();
    List<Integer> visited = new ArrayList<>();
    int scc = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            System.out.println("Enter vertices");
            int V = Integer.parseInt(sc.next());
            System.out.println("Enter edge");
            int E = Integer.parseInt(sc.next());

            for (int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());

            for (int i = 1; i <= E; i++) {
                int u = Integer.parseInt(sc.next());
                int v = Integer.parseInt(sc.next());

                // adding directed edges between
                // vertex 'u' and 'v'
                adj.get(u).add(v);
            }

            StronglyConnComp_Kosaraju ob = new StronglyConnComp_Kosaraju();
            System.out.println(ob.kosaraju(V, adj));
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < V; i++) {
            if (visited.contains(i))
                continue;
            // visited.add(i);
            DFS(adj, i, true);
        }
        // System.out.println(nodes);
        // [0, 3, 4, 2, 1]
        ArrayList<ArrayList<Integer>> revGraph = reverseGraph(adj, V);
        // System.out.println(revGraph);
        // [[1], [2], [0], [0], [3]]
        // Clear the visited list
        visited.clear();
        buildGraph(revGraph);
        return scc;
    }

    // This is the first pass DFS
    private void DFS(ArrayList<ArrayList<Integer>> adj, int idx, boolean isFirstPass) {
        visited.add(idx);
        ArrayList<Integer> vertices = adj.get(idx);

        for (int i = 0; i < vertices.size(); i++) {
            int vertex = vertices.get(i);
            if (visited.contains(vertex))
                continue;
            DFS(adj, vertex, isFirstPass);
        }
        if (isFirstPass)
            nodes.addFirst(idx);
    }

    private void buildGraph(ArrayList<ArrayList<Integer>> adj) {
        while (!nodes.isEmpty()) {
            // Pop the first element
            int ele = nodes.removeFirst();
            if (visited.contains(ele)) {
                continue;
            }
            // Visit all childrens of this vertex
            DFS(adj, ele, false);
            ++scc;
        }
    }

    private ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> reverseAdjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            reverseAdjList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> iNodes = adj.get(i);
            for (int j = 0; j < iNodes.size(); j++) {
                int vertex = iNodes.get(j);
                reverseAdjList.get(vertex).add(i);
            }
        }
        return reverseAdjList;
    }

}
