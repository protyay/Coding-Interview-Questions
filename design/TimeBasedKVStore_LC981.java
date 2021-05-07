import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TimeBasedKVStore_LC981 {
    //SDE problem
    private final Map<String, NavigableMap<Integer, String>> timeMap;

    /** Initialize your data structure here. */
    public TimeBasedKVStore_LC981() {
        this.timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        this.timeMap.computeIfAbsent(key, k -> new TreeMap<>());
        this.timeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        Map.Entry<Integer, String> fetchEntry = this.timeMap.containsKey(key)
                ? this.timeMap.get(key).floorEntry(timestamp)
                : null;
        if (fetchEntry == null)
            return "";
        return fetchEntry.getValue();
    }
}
