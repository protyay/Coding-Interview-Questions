import java.util.HashMap;
import java.util.Map;

public class ContiniousSubarrSum_LC523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> preMod = new HashMap<>();
        preMod.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preMod.containsKey(sum % k) && i - preMod.get(sum % k) > 1)
                return true;
            preMod.put(sum % k, i);
        }
        return false;
    }
}
