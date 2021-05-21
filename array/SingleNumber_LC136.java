public class SingleNumber_LC136 {
    // Repeat
    public int singleNumber(int[] nums) {
        // XOR property
        int a = 0;
        for(int n : nums){
            a ^= n;
        }
        return a;
    }
}
/**
 * res = 7 ^ 3 ^ 5 ^ 4 ^ 5 ^ 3 ^ 4

Since XOR is associative and commutative, above
expression can be written as:
res = 7 ^ (3 ^ 3) ^ (4 ^ 4) ^ (5 ^ 5)
= 7 ^ 0 ^ 0 ^ 0
= 7 ^ 0
= 7

If we take XOR of zero and some bit, it will return that bit
A XOR 0 = A;
If we take XOR of two same bits, it will return 0
A XOR A = 0;
XOR is associative and commutaive
A XOR B XOR A = (A XOR A) XOR C = 0 XOR C = C;
 */
