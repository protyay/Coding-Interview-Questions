import java.util.*;

public class ReconstructIti_LC332 {
    private final String START = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {

        if (tickets.size() == 1)
            return tickets.get(0);
        Map<String, Queue<String>> edgeMap = new HashMap<>();
        LinkedList<String> itinerary = new LinkedList<>();

        for (List<String> ticket : tickets) {
            edgeMap.computeIfAbsent(ticket.get(0), t -> new PriorityQueue<String>());
            edgeMap.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs(START, edgeMap, itinerary);
        return itinerary;
    }

    private void dfs(String start, Map<String, Queue<String>> routes, LinkedList<String> journey) {
        Queue<String> nextStop = routes.get(start);
        while (nextStop != null && !nextStop.isEmpty()) {
            dfs(nextStop.remove(), routes, journey);
        }
        journey.addFirst(start);
    }
}
