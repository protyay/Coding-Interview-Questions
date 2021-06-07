package String;

public class NextSmallestPallindrome {
    
    public static String nextSmallerPalindrome(String s) {
        // Write you code here.
        if (s == null)
            return s;
        if (s.length() == 1) {
            int digit = s.charAt(0) - '0';
            return String.valueOf(digit - 1);
        }
        // The very crucial part of the problem is to understand that
        // that modifying a pallindrome to form another pallindrome involves
        // modifying simultaneously on the string
        char[] c = s.toCharArray();
        int N = c.length;
        int mid = N / 2;
        for (int i = mid; i < c.length; i++) {
            int currDigit = c[i] - '0';
            if (currDigit > 0) {
                c[i] = c[N - 1 - i] = (char) ((currDigit - 1) + '0');
                break;
            } else {
                c[i] = c[N - 1 - i] = '9';
            }
        }
        // Handle scenarios with leading zero
        if (c[0] == '0') {
            c[0] = '9';
            s = String.valueOf(c);
            s = s.substring(0, N - 1);
        } else
            s = String.valueOf(c);
        return s;
    }
}
