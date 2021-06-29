public class Strstr_LC28 {
    private int[] lps;
    private String pattern;

    // KMP Algorithm
    // SDE
    public int strStr(String text, String pattern) {
        if (pattern == null || pattern.isBlank())
            return 0;
        this.pattern = pattern;
        buildLPS(pattern);
        return search(text);
    }

    public int search(String text) {
        int m = pattern.length();
        int n = text.length();
        int i = 0, j = 0;// i and j will iterate through the text and pattern respectively
        char[] ch = text.toCharArray();
        char[] pat = this.pattern.toCharArray();

        while (i < n) {
            if (ch[i] == pat[j]) {
                i++;
                j++;
            } else {
                if (j > 0)
                    j = lps[j - 1];
                else
                    i++;
            }
            if (j == m)
                return i - j;
        }

        return -1;
    }

    public int[] buildLPS(String pattern) {
        int m = pattern.length();
        this.lps = new int[m];
        int len = 0, i = 1;
        char[] pat = pattern.toCharArray();

        while (i < m) {
            if (pat[i] == pat[len]) {
                lps[i] = len + 1;
                i++;
                len++;
            } else {
                if (len > 0)
                    len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        // System.out.println(Arrays.toString(lps));
        return lps;
    }

}