public class Strstr_LC28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty())
            return 0;
        if (haystack.length() < needle.length())
            return -1;
        RabinKarp rk = new RabinKarp(needle);
        return rk.search(haystack);
    }
}
// https://algs4.cs.princeton.edu/lectures/keynote/53SubstringSearch-2x2.pdf
class RabinKarp {

    private long patternHash;
    private final int R;
    private final int Q;
    private String pattern;
    private final int M;
    private int RM1;

    RabinKarp(String pattern) {
        this.pattern = pattern;
        this.R = 256;
        this.Q = 997;
        this.M = pattern.length();

        this.patternHash = this.hash(pattern);
        this.RM1 = 1;
        for (int i = 1; i < this.M; i++) {
            this.RM1 = (this.RM1 * R) % Q;
        }
    }

    private long hash(String pattern) {
        if (pattern == null || pattern.length() == 0)
            return -1;

        long hash = 0;
        for (int i = 0; i < this.M; i++) {
            hash = (hash * this.R + pattern.charAt(i)) % this.Q;
        }
        return hash;
    }

    int search(String text) {
        if (text == null)
            return -1;
        if (text.length() < this.M)
            return -1;

        long textHash = this.hash(text);
        if (textHash == this.patternHash && this.charCheck(0, text))
            return 0;
        int N = text.length();

        for (int i = this.M; i < N; i++) {
            textHash = (textHash + this.Q - RM1 * text.charAt(i - this.M) % this.Q) % this.Q;
            textHash = (textHash * this.R + text.charAt(i)) % this.Q;

            int from = i - M + 1;
            if (textHash == this.patternHash && this.charCheck(from, text))
                return from;
        }
        return -1;
    }

    private boolean charCheck(int from, String text) {
        for (int i = 0; i < this.M; i++) {
            if (this.pattern.charAt(i) != text.charAt(i + from))
                return false;
        }
        return true;
    }
}