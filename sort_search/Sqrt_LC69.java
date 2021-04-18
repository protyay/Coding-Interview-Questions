public class Sqrt_LC69 {
    public int mySqrt(int x) {
        // 1 2 3 4 5 6 7 8
        if (x == 0)
            return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1))
                return mid;
            if (mid > x / mid)
                end = mid;
            if (mid < x / mid)
                start = mid + 1;
        }
        return start;
    }
}
/**
 * One of the finest Binary Search problems which explore 
 * how to think from FIRST principles.
 * Essentially we are trying to find the upper bound MID, such
 * that MID * MID <= X and (MID + 1)*(MID + 1) > X
 * To prevent overflow, we write MID <= X/MID
 */
