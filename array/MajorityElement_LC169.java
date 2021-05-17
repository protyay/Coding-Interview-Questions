public class MajorityElement_LC169 {
    // SDE problem
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int el = -1;
        for (int num : nums) {
            if (cnt == 0) {
                el = num;
            }
            if (num == el)
                cnt++;
            else
                cnt--;
        }
        return el;
    }
}
/**
 * Moore's Voting algorithm
 */
