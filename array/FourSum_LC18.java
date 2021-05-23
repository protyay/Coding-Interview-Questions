import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_LC18 {
    // SDE problem
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums.length < 4)
            return res;

        Arrays.sort(nums);
        int N = nums.length;

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int sum = nums[i] + nums[j];
                int lo = j + 1, hi = N - 1;
                while (lo < hi) {
                    int total = sum + nums[lo] + nums[hi];

                    if (total == target) {
                        List<Integer> quad = List.of(nums[i], nums[j], nums[lo], nums[hi]);
                        while (lo < hi && nums[lo] == quad.get(2))
                            lo++;
                        while (lo < hi && nums[hi] == quad.get(3))
                            hi--;

                        res.add(quad);
                    } else if (total < target)
                        lo++;
                    else
                        hi--;
                }
                while (j + 1 < nums.length - 2 && nums[j + 1] == nums[j])
                    j++;
            }
            while (i + 1 < nums.length - 3 && nums[i + 1] == nums[i])
                i++;
        }
        return res;
    }
}
