public class Strstr_LC28 {
    // Implementation of Rabin-Karp algorithm

    public int strStr(String haystack, String needle) {
        if (needle.isEmpty())
            return 0;
        if (haystack.isEmpty())
            return needle.isEmpty() ? 0 : -1;
        int patternHash = calcRKHash(needle);
        int pLen = needle.length();
        for (int i = 0; i <= haystack.length() - pLen; i++) {
            String s = haystack.substring(i, i + pLen);
            int sHash = calcRKHash(s);
            boolean isFound = sHash == patternHash && s.equals(needle);
            if (isFound)
                return i;
        }
        return -1;
    }

    private int calcRKHash(String input) {
        // String consists of only lowercase characters. hence p=31
        int p = 31;
        int m = (int) Math.pow(10, 5);
        char[] ch = input.toCharArray();
        int hash = 0;
        for (int i = 0; i < ch.length; i++) {
            int code = ch[i] - 'a' + 1;
            hash += (int) Math.pow(p, ch.length - i - 1) * code;
        }
        return hash % m;
    }
}
