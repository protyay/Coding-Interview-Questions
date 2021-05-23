public class PowXN_LC50 {
    // SDE
    // Repeat
    public double myPow(double x, int n) {
        // We'll implement fast binary exp.method
        if (n == 1 || x == 1)
            return x;
        long k = n;
        if (k < 0)
            k = -1 * k;
        double ans = 1.0;

        while (k > 0) {
            if (k % 2 == 0) {
                k /= 2;
                x *= x;
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
 * Fast binary exponentiation method Edge case for Integer.MIN_VALUE is a
 * crucial one Questions - if N (power) can be negative ?
 * 
 * Because N can be negative and it can go upto Integer.MIN_VALUE, we need to
 * have a long variable to hold the absolute value. Hence we introduced long k =
 * n < 0 ? -1 * n : n;
 */