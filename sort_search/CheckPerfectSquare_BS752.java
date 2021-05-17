public class CheckPerfectSquare_BS752 {
    public boolean solve(int n) {
        if (n == 0)
            return true;
        long lo = 0, hi = n;
        long prod = 0;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            prod = mid * mid;
            if (prod == n)
                return true;
            else if (prod < n)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckPerfectSquare_BS752 bs752 = new CheckPerfectSquare_BS752();
        boolean ans = bs752.solve(36100000);
        System.out.println("Ans =" + ans);
    }
}
/*
 * Take care of overflow in binary search.

 */
