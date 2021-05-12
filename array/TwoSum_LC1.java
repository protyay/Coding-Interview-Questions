import java.util.HashMap;
import java.util.Map;

public class TwoSum_LC1 {
    public int[] twoSum(int[] nums, int target) {
        // At every point we try to find the x ;
        // 3 2 4; 6
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int find = target - nums[i];
            if (map.containsKey(find)) {
                res[0] = Math.min(i, map.get(find));
                res[1] = Math.max(i, map.get(find));

                break;// There exists only one solution
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
