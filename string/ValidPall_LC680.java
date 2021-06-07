public class ValidPall_LC680 {
    //SDE
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
/**
 * Why this is an important problem ? Because it builds on the simple characteristics of a pallindrome.
 * How we can build a pallindrome by removing characters
 * How should we explain the TC of this kind of problem
 */
