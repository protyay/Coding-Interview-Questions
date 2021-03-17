public class AlternatingBinStr_GFG {

    // Function to return the minimum number of
    // characters of the given binary string
    // to be replaced to make the string alternating
    static int minReplacement(String s, int len) {
        int ans = 0;
        for (int i = 0; i < len; i++) {

            // If there is 1 at even index positions
            if (i % 2 == 0 && s.charAt(i) == '1')
                ans++;

            // If there is 0 at odd index positions
            if (i % 2 == 1 && s.charAt(i) == '0')
                ans++;
        }
        return Math.min(ans, len - ans);
    }

    // Driver code
    public static void main(String args[]) {
        String s = "1100";
        int len = s.length();
        System.out.print(minReplacement(s, len));
    }

}
