import java.util.*;

public class CheapestFlightWithinKStops_LC787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Route>> edges = new HashMap<>();
        Queue<Route> q = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        for (int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            List<Route> routes = edges.getOrDefault(flight[0], new ArrayList<>());
            // We have a list of routes from the given stop
            Route route = new Route(flight[1], flight[2], K);
            routes.add(route);
            edges.put(flight[0], routes);
        }
        // System.out.println(edges);
        q.add(new Route(src, 0, K));
        while (!q.isEmpty()) {
            int size = q.size();
            // Queue<Route> nextStopCost = new PriorityQueue<>((a, b) ->
            // Integer.compare(a.cost, b.cost));
            while (size-- > 0) {
                Route currSrc = q.remove();
                if (currSrc.stop == dst)
                    return currSrc.cost;
                if (currSrc.stopRemaining >= 0) {
                    List<Route> nextDest = edges.containsKey(currSrc.stop) ? edges.get(currSrc.stop)
                            : new ArrayList<>();
                    for (int i = 0; i < nextDest.size(); i++) {
                        Route dest = nextDest.get(i);
                        q.add(new Route(dest.stop, currSrc.cost + dest.cost, currSrc.stopRemaining - 1));
                    }
                }
            }
            // q = nextStopCost;
        }
        return -1;
    }

    public int findCheapestPrice_DFS(int n, int[][] flights, int src, int dst, int K) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Pair>());
        }
        for (int[] flight : flights) {
            adjList.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        // DFS without pruning
        int cost = 0;
        boolean[] visited = new boolean[n];
        List<Pair> srcEdge = adjList.get(src);
        int pathSum = Integer.MAX_VALUE;
        for (Pair p : srcEdge) {
            pathSum = Math.min(dfs(adjList, p, dst, K, visited), pathSum);
        }
        return cost;
    }

    private int dfs(List<List<Pair>> adjList, Pair node, int dst, int K, boolean[] visited) {
        if (K < 0)
            return -1;
        if (node.location == dst)
            return node.cost;
        int cost = 0;
        visited[node.location] = true;
        List<Pair> des = adjList.get(node.location);
        for (Pair p : des) {
            if (visited[p.location])
                continue;
                int pathCost = dfs(adjList, p, dst, K - 1, visited);
                if(pathCost == -1) return -1;
                else
                 cost = node.cost + pathCost ;
        }
        return cost;
    }

    public static void main(String[] args) {
        CheapestFlightWithinKStops_LC787 lc787 = new CheapestFlightWithinKStops_LC787();
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 }, { 2, 3, 60 } };
        // int[][] flights = { { 0, 1, 2 }, { 1, 2, 1 }, { 2, 0, 50 } };
        // int cost = lc787.findCheapestPrice(4, flights, 0, 2, 1);
        int dfsCost = lc787.findCheapestPrice_DFS(4, flights, 0, 2, 1);
        // System.out.println("Min cost is =" + cost);
        System.out.println("Min DFS cost is =" + dfsCost);
    }
}

class Route {
    int stop;
    int cost;
    int stopRemaining;

    Route(int stop, int cost, int stopRemaining) {
        this.stop = stop;
        this.cost = cost;
        this.stopRemaining = stopRemaining;
    }

    public String toString() {
        return "Stop is " + this.stop + " with cost = " + this.cost;
    }
}

class Pair {
    int location;
    int cost;

    Pair(int location, int cost) {
        this.location = location;
        this.cost = cost;
    }
}