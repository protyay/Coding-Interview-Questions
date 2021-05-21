import java.util.ArrayList;
import java.util.List;

public class MajorityElement_NBy3_LC229 {
    // SDE problem
    // Repeat
    public List<Integer> majorityElement(int[] nums) {
        Integer candA = null, candB = null;
        int c1 = 0, c2 = 0;
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            if (candA != null && candA == num) {
                c1++;
            } else if (candB != null && candB == num) {
                c2++;
            } else if (c1 == 0) {
                candA = num;
                c1++;
            } else if (c2 == 0) {
                candB = num;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        int countA = 0, countB = 0;
        for (int num : nums) {
            if (candA != null && candA == num)
                ++countA;
            if (candB != null && candB == num)
                ++countB;
        }
        if (countA > nums.length / 3)
            ans.add(candA);
        if (countB > nums.length / 3)
            ans.add(candB);
        return ans;
    }
}
