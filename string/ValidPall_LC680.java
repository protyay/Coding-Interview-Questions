public class ValidPall_LC680 {
    public boolean validPalindrome(String str) {
        if (str.length() == 1)
            return true;

        int s = 0, e = str.length() - 1;
        char[] ch = str.toCharArray();
        while (s < e) {
            if (ch[s] != ch[e]) {
                return isPal(str.substring(s + 1, e + 1)) || isPal(str.substring(s, e));
            }
            ++s;
            --e;
        }
        return true;
    }

    private boolean isPal(String input) {
        int s = 0, end = input.length() - 1;
        char[] ch = input.toCharArray();

        while (s < end) {
            if (ch[s] != ch[end])
                return false;
            ++s;
            --end;
        }
        return true;
    }
}
