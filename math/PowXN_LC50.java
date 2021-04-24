public class PowXN_LC50 {
    public double myPow(double x, int n) {
        if (n == 1)
            return x;
        if (n == Integer.MIN_VALUE)
            return Math.abs(x) == 1 ? 1 : 0;
        long k = n < 0 ? -1 * n : n;
        double ans = 1.0;
        while (k > 0) {
            if (k % 2 == 0) {
                x *= x;
                k /= 2;
            } else {
                ans *= x;
                k -= 1;
            }
        }
        if (n < 0)
            ans = 1.0 / ans;
        return ans;
    }
}
/**
 * Fast binary exponentiation method
 * Edge case for Integer.MIN_VALUE is a crucial one
 */