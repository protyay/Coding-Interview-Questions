public class LongestCommPrefix_BS420 {
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