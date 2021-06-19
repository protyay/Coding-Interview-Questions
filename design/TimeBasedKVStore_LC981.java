import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKVStore_LC981 {
    // SDE problem
    private final Map<String, List<Value>> map;

    /** Initialize your data structure here. */
    public TimeBasedKVStore_LC981() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(key, k -> new ArrayList<>());
        this.map.get(key).add(new Value(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!this.map.containsKey(key))
            return "";
        return find(key, timestamp);
    }
    // Using binary search we find the maximum value lower than the
    // given timestamp

    private String find(String key, int timestamp) {
        List<Value> values = this.map.get(key);
        int start = 0, end = values.size() - 1;
        String ans = "";

        while (start <= end) {
            int mid = start + ((end - start) / 2);

            Value midValue = values.get(mid);
            if (midValue.time == timestamp) {
                return midValue.value;
            } else if (midValue.time < timestamp) {
                ans = midValue.value;
                start = mid + 1;
            } else
                end = mid - 1;
        }
        return ans;
    }
}

class Value {
    int time;
    String value;

    Value(int time, String value) {
        this.time = time;
        this.value = value;
    }
}
