import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class IntegerToRoman_LC12 {
    public String intToRoman(int n) {
        // Select the largest value smaller than the given integer
        // Add it
        // For the remainder , recursively follow the same procedure and built the
        // answer
        NavigableMap<Integer, String> roman = new TreeMap<>();
        roman.put(1, "I");
        roman.put(5, "V");
        roman.put(10, "X");
        roman.put(50, "L");
        roman.put(100, "C");
        roman.put(500, "D");
        roman.put(1000, "M");

        // Special Case handling
        roman.put(4, "IV");
        roman.put(9, "IX");
        roman.put(40, "XL");
        roman.put(90, "XC");
        roman.put(400, "CD");
        roman.put(900, "CM");

        String ans = buildRoman(n, new StringBuilder(), roman);
        return ans;
    }

    private String buildRoman(int n, StringBuilder str, NavigableMap<Integer, String> mappings) {
        if (n == 0)
            return str.toString();
        if (mappings.containsKey(n))
            return str.append(mappings.get(n)).toString();
        Map.Entry<Integer, String> pair = mappings.floorEntry(n);
        if (pair != null) {
            String symbol = pair.getValue();
            str.append(symbol);
            return buildRoman(n - pair.getKey(), str, mappings);
        }
        return null;
    }
}
