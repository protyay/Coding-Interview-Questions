public class StringCompression_LC443 {
    public int compress(char[] chars) {
        
        int writeIdx = 0, index = 0;
        while (index < chars.length) {
            char currCh = chars[index];
            int count = 0;
            while (index < chars.length && currCh == chars[index]) {
                ++index;
                ++count;
            }
            chars[writeIdx++] = currCh;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[writeIdx++] = c;
                }
            }
        }
        return writeIdx;
    }
}
/**
 * Runs in O(N) time and constant space.
 * Very very important question
 */
