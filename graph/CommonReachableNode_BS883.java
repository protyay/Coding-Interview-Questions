import java.util.*;

public class CommonReachableNode_BS883 {
    public boolean solve(int[][] edges, int a, int b) {
        // Count the total number of vertices
        int N = countVtx(edges);
        System.out.println(N);
        // Essentially you build the adjList of the transposed graph
        List<List<Integer>> adjList = transpose(edges, N);

        // DFS/BFS Graph exploration from A
        boolean[] visitedFromA = new boolean[adjList.size()];
        dfs(a, adjList, visitedFromA);

        // DFS/BFS Graph Exploration from B
        boolean[] visitedFromB = new boolean[adjList.size()];
        dfs(b, adjList, visitedFromB);

        for (int i = 0; i < N; i++) {
            if (visitedFromA[i] && visitedFromB[i])
                return true;
        }
        return false;
    }

    // This is a simple problem. O(E)
    private int countVtx(int[][] edges) {
        int N = 0;
        for (int[] edge : edges) {
            N = Math.max(N, Math.max(edge[0], edge[1]));
        }
        N++;
        return N;
    }

    // Given a set of edges, build the adj list of the transpose graph
    // O(|V| + |E|)
    private List<List<Integer>> transpose(int[][] edges, int N) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            List<Integer> neighbours = adjList.get(edge[1]);
            neighbours.add(edge[0]);
        }
        return adjList;
    }

    // DFS graph exploration
    // O(|V| + |E|)
    private void dfs(int start, List<List<Integer>> adjList, boolean[] visited) {
        visited[start] = true;
        List<Integer> neighbours = adjList.get(start);
        for (int i = 0; i < neighbours.size(); i++) {
            // Visit each of the neighbours, iff they are NOT already visited
            if (visited[neighbours.get(i)])
                continue;
            dfs(neighbours.get(i), adjList, visited);
        }
    }
}
