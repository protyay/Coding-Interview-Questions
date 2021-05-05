public class LongestCommPrefix_BS420 {
    // SDE problem
    public String solve(String[] words) {
        // Assign the first string as the default lcp
        if (words == null || words.length == 0)
            return "";
        String lcp = words[0];
        int lcpSize = lcp.length();
        for (int i = 1; i < words.length; i++) {
            lcpSize = Math.min(lcpSize, words[i].length());
            int k = 0;
            while (k < lcpSize && lcp.charAt(k) == words[i].charAt(k)) {
                ++k;
            }
            lcpSize = k;
            // Can we eliminate substring at each index
            lcp = lcp.substring(0, lcpSize);
        }
        return lcp;
    }
}
/**
 * Runtime - O(M*N)
 */
class LCP_LC14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        // We take the first string as the reference,
        // iterate through each of the string , checking if the char are equal
        int index = 0;
        String ref = strs[0];
        String lcp = "";

        for (char c : ref.toCharArray()) {
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != c)
                    return lcp;
            }
            lcp += c;
            index++;
        }
        return lcp;
    }
}