public class CountBinarySubstr_LC696 {
    // SDE // Medium
    public int countBinarySubstrings(String s) {
        int count = 0, pre = 0, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                count += Math.min(pre, curr);
                pre = curr;
                curr = 1;
            } else
                curr++;
        }
        return count + Math.min(pre, curr);
    }
}
/**
 * The intuition behind this problem is to grasp that we need 
 * to maintain the groups of consecutive character
 * When we are changing groups, we count bin substring from min of the curr group 
 * and the prev group
 */
