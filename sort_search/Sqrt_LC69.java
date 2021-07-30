public class Sqrt_LC69 {
    // SDE
    public int mySqrt(int x) {
        if (x == 0)
            return 0;

        if (x <= 3)
            return 1;
        int lo = 1, hi = x / 2;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (x / mid == mid)
                return mid;
            else if (mid < x / mid && (mid + 1) > x / (mid + 1))
                return mid;
            else if (mid < x / mid)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return lo;
    }
}
/**
 * One of the finest Binary Search problems which explore how to think from
 * FIRST principles. Essentially we are trying to find the upper bound MID, such
 * that MID * MID === X OR (mid*mid < x && (MID + 1)*(MID + 1) > X) To prevent
 * overflow, we write MID <= X/MID
 */
