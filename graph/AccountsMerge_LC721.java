import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge_LC721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailtoName = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                graph.computeIfAbsent(account.get(i), a -> new HashSet<>());
                emailtoName.put(account.get(i), name);

                if (i == 1)
                    continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        for (String email : emailtoName.keySet()) {
            if (visited.add(email)) {
                List<String> mergedList = new LinkedList<>();
                dfs(graph, visited, mergedList, email);
                Collections.sort(mergedList);
                mergedList.add(0, emailtoName.get(email));

                ans.add(mergedList);
            }
        }
        return ans;
    }

    private void dfs(Map<String, Set<String>> graph, Set<String> visited, List<String> merged, String email) {
        merged.add(email);
        Set<String> next = graph.getOrDefault(email, new HashSet<String>());
        for (String mail : next) {
            if (visited.add(mail)) {
                dfs(graph, visited, merged, mail);
            }
        }
    }
}
/**
 * DFS has a similar running time as compared to the UF solution. But this takes extra time
 * to build the adj list going through all of the accounts
 * 
 */
