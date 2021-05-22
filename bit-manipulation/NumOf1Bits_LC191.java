public class NumOf1Bits_LC191 {
    // SDE problem Repeat
    public int hammingWeight(int n) {
        int one = 0, bitMask = 1, start = 0;
        while (start++ <= 31) {
            if ((n & bitMask) != 0)
                ++one;
            bitMask <<= 1;
        }
        return one;
    }
}
/**
 * Simple yet effective problem to iterate through all 31 bits and count some value
 */