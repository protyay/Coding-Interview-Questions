import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// SDE(Optional) Problem

public class SubdomainVisitCount_LC811 {
    public List<String> subdomainVisits(String[] cpdomains) {

        List<String> res = new ArrayList<>();
        Map<String, Integer> visitCount = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] tokens = cpdomain.split(" ");
            int count = Integer.parseInt(tokens[0]);
            visitCount.put(tokens[1], visitCount.getOrDefault(tokens[1], 0) + count);
            int index = 0;
            for (char ch : tokens[1].toCharArray()) {
                if (ch == '.') {
                    String parentDomain = tokens[1].substring(index + 1);
                    visitCount.put(parentDomain, visitCount.getOrDefault(parentDomain, 0) + count);
                }
                ++index;
            }
        }
        for (String domain : visitCount.keySet()) {
            res.add(visitCount.get(domain) + " " + domain);
        }
        return res;
    }
}
// Focusses on string tokenization and hashmap usage
