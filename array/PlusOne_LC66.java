import java.util.Arrays;

public class PlusOne_LC66 {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int sum = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum = digits[i] + sum;
            res[i + 1] = sum % 10;
            sum /= 10;
        }
        if (sum > 0) {
            res[0] = sum;
            return res;
        }
        return Arrays.copyOfRange(res, 1, res.length);
    }
}
