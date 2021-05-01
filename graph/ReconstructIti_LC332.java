import java.util.*;

public class ReconstructIti_LC332 {
    // SDE problem
    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, Queue<String>> cityEdges = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            cityEdges.computeIfAbsent(from, (city) -> new PriorityQueue<String>());
            cityEdges.get(from).add(to);
        }
        LinkedList<String> res = new LinkedList<>();
        dfs(cityEdges, "JFK", res);
        return res;
    }

    private void dfs(Map<String, Queue<String>> airportEdges, String currCity, LinkedList<String> res) {

        while (airportEdges.containsKey(currCity) && !airportEdges.get(currCity).isEmpty())
            dfs(airportEdges, airportEdges.get(currCity).remove(), res);

        res.addFirst(currCity);
    }
}
/**
 * Eulerian Path traversal. The reason we use LinkedList is to ONLY add a path
 * when we are sure we have a valid solution. For this problem, the valid
 * solution, is when 1. We use each ticket once. 2. We visit all the
 * nodes(Airports)
 */
