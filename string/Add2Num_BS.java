import java.util.Arrays;
/**
 * One of the most important string problem. 
 * Int to char and vice-versa conversion and general int and string conversion
 */
public class Add2Num_BS {
    public String solve(String a, String b) {
        if (a.isEmpty())
            return b;
        if (b.isEmpty())
            return a;
        // Reverse the string
        // 933
        // 099
        int resLen = Math.max(a.length(), b.length());

        int diff = Math.abs(a.length() - b.length());
        if (diff > 0) {
            String append = "0".repeat(diff);
            if (a.length() < b.length()) {
                a = append + a;
            } else {
                b = append + b;
            }
        }
        char[] res = new char[resLen + 1];
        Arrays.fill(res, '0');
        char[] chA = a.toCharArray();
        char[] chB = b.toCharArray();
        int carry = 0;
        int K = res.length - 1;
        int i = chA.length - 1, j = chB.length - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int placeValue = (chA[i] - '0') + (chB[j] - '0') + carry;
            // System.out.println(placeValue);
            res[K] = (char) ((placeValue % 10) + '0');
            // System.out.println(Arrays.toString(res));
            carry = placeValue / 10;
            K--;
        }
        if (carry > 0) {
            res[K] = (char) (carry + '0');
        }
        String ans = new String(res);
        if (ans.charAt(0) == '0')
            ans = ans.substring(1);
        return ans;
    }

    public static void main(String[] args) {
        Add2Num_BS bs = new Add2Num_BS();
        String ans = bs.solve("933", "99");
        System.out.println("Ans =" + ans);
        char c = (char) (2 + '0');
        System.out.println(c);
    }
}
