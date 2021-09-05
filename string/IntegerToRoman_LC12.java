import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class IntegerToRoman_LC12 {
    public String intToRoman(int num) {
        // Select the largest value smaller than the given integer
        // Add it
        // For the remainder , recursively follow the same procedure and built the
        // answer
        NavigableMap<Integer, String> roman = new TreeMap<>();
        final StringBuilder str = new StringBuilder();
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

        while (num > 0) {
            Map.Entry<Integer, String> value = roman.floorEntry(num);

            str.append(value.getValue());

            num -= value.getKey();
        }
        return str.toString();
    }
}
