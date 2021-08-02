import java.util.*;

public class CheapestFlightWithinKStops_LC787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Destination>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Destination>());
        }
        for (int[] edge : flights) {
            int from = edge[0];
            int to = edge[1];
            int price = edge[2];

            graph.get(from).add(new Destination(to, price, 0));
        }
        Integer[] price = new Integer[n];
        price[src] = 0;
        Deque<Destination> q = new ArrayDeque<>();

        q.addLast(new Destination(src, 0, 0));

        while (!q.isEmpty()) {
            Destination curr = q.removeFirst();
            // Relax all edges starting from the current city
            List<Destination> currEdges = graph.get(curr.city);
            for (Destination e : currEdges) {
                int dest = e.city;
                if (curr.stops > k)
                    continue;

                int updatedPrice = e.price + curr.price;
                if (price[dest] == null || updatedPrice < price[dest]) {
                    price[dest] = updatedPrice;
                    q.addLast(new Destination(dest, updatedPrice, curr.stops + 1));
                }
            }
        }
        return price[dst] == null ? -1 : price[dst];
    }

    class Destination {
        int city;
        int price;
        int stops;

        Destination(int city, int price, int stops) {
            this.city = city;
            this.price = price;
            this.stops = stops;
        }

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = { { 2, 3, 1 }, { 1, 2, 1 }, { 0, 2, 5 }, { 0, 1, 1 } };
        int src = 0, dest = 3, stops = 1;

        CheapestFlightWithinKStops_LC787 lc787 = new CheapestFlightWithinKStops_LC787();

        int price = lc787.findCheapestPrice(n, flights, src, dest, stops);
        System.out.println("Cheapest price =" + price);
    }
}
/**
 * Two very important questions to ask about this question. Why don't we require
 * the PQ like in the traditional Djikstra and why we choose to continue inside
 * the while loop instead of breaking.
 * 
 * In Djikstra's algorithm(which this is NOT), we would typically always select the shortest path
 * to a node. This ensures we always choose the local optimum so that we would never need to visit
 * the same edge twice
 * 
 */
