import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Map<String, Integer> value = new HashMap<>();
        
        value.put("I", 1);
        value.put("V", 5);
        value.put("X", 10);
        value.put("L", 50);
        value.put("C", 100);
        value.put("D", 500);
        value.put("M", 1000);
        // Special cases
        value.put("IV", 4);
        value.put("IX", 9);
        
        value.put("XL", 40);
        value.put("XC", 90);
        
        value.put("CD", 400);
        value.put("CM", 900);
        
        char[] ch = s.toCharArray();
        int ans = 0;
        
        //Understand that the double digit HAS more priority over the single digit
        int i = 0;
        while(i < ch.length){
            String singleChar = Character.toString(ch[i]);
            String doubleChar = null;
            
            if(i + 1 < ch.length){
                doubleChar = singleChar.concat(Character.toString(ch[i+1]));
            }
            if(value.containsKey(doubleChar)) {
                ans += value.get(doubleChar); i += 2;
            }
            else { 
                ans += value.get(singleChar); 
                ++i;
            }
        }
        return ans;
    }
}
