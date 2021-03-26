import java.util.*;
import java.util.stream.Collectors;

public class TarjanSCCAlgo {
    private List<List<Integer>> graph;
    private int sccCount;
    private boolean[] visited;
    private int N;
    private int[] ids, lowLinks, sccs;
    private int vertexId;
    private Deque<Integer> stack;

    private final int UNVISITED = -1;

    public TarjanSCCAlgo(List<List<Integer>> adjList) {
        this.graph = adjList;
        this.N = adjList.size();
        this.visited = new boolean[this.N];
        this.ids = new int[this.N];
        this.lowLinks = new int[this.N];
        this.sccs = new int[this.N];
        this.stack = new ArrayDeque<>();
        Arrays.fill(ids, UNVISITED);
        this.vertexId = 0;
    }

    public int[] solveTarjanSCC() {
        if (this.graph == null)
            throw new IllegalArgumentException("Graph cannot be NULL");

        for (int i = 0; i < this.N; i++) {
            if (ids[i] == UNVISITED)
                dfs(i);
        }
        return this.sccs;
    }

    private void dfs(int at) {
        ids[at] = lowLinks[at] = vertexId++;
        this.stack.addFirst(at);
        visited[at] = true;

        for (int to : this.graph.get(at)) {
            if (this.ids[to] == UNVISITED) {
                dfs(to);
            }
            if (this.visited[to]) {
                this.lowLinks[at] = Math.min(this.lowLinks[at], this.lowLinks[to]);
            }
        }
        if (this.lowLinks[at] == this.ids[at]) {
            // We have reached the start of a SCC

            while (!this.stack.isEmpty() && this.lowLinks[this.stack.getFirst()] == this.lowLinks[at]) {
                this.visited[this.stack.getFirst()] = false;
                this.sccs[this.stack.getFirst()] = this.sccCount;
                this.stack.removeFirst();
            }
            this.sccCount++;
        }
    }

    public static void main(String[] args) {
        int N = 8;
        GraphBuilder graphBuilder = new GraphBuilder();
        List<List<Integer>> adjList = graphBuilder.buildGraph(N);
        TarjanSCCAlgo sccAlgo = new TarjanSCCAlgo(adjList);
        int[] scc = sccAlgo.solveTarjanSCC();

        Map<Integer, List<Integer>> vertexToSCCMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            vertexToSCCMap.computeIfAbsent(scc[i], k -> new ArrayList<Integer>());
            vertexToSCCMap.get(scc[i]).add(i);
        }
        System.out.printf("Total number of strongly connected component is = %d \n", scc.length);
        for (List<Integer> sccs : vertexToSCCMap.values()) {
            String vertexGraph = sccs.stream().map(i -> String.valueOf(i)).collect(Collectors.joining("->"));
            System.out.printf("Following vertex forms a strongly connected component , %s \n", vertexGraph);
        }
    }

}

class GraphBuilder {

    public List<List<Integer>> buildGraph(int N) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 0);
        addEdge(adjList, 3, new int[] { 4, 7 });
        addEdge(adjList, 4, 5);
        addEdge(adjList, 5, new int[] { 0, 6 });
        addEdge(adjList, 6, new int[] { 0, 2, 4 });
        addEdge(adjList, 7, new int[] { 3, 5 });

        return adjList;
    }

    public void addEdge(List<List<Integer>> adjList, int from, int... to) {
        for (int toEdge : to) {
            adjList.get(from).add(toEdge);
        }
    }
}
