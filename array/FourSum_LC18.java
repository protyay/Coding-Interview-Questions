import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_LC18 {
    // SDE problem
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int N = nums.length;
        if (N < 4)
            return ans;

        Arrays.sort(nums);
        for (int i = 0; i < N - 3;) {
            for (int j = i + 1; j < N - 2;) {
                int s = j + 1, e = N - 1;
                while (s < e) {
                    int total = nums[i] + nums[j] + nums[s] + nums[e];
                    if (total == target) {
                        List<Integer> res = List.of(nums[i], nums[j], nums[s], nums[e]);
                        ++s;
                        --e;
                        while (s < e && nums[s] == nums[s - 1])
                            s++;
                        while (s < e && nums[e] == nums[e + 1])
                            e--;
                        ans.add(res);
                    } else if (total < target)
                        s++;
                    else
                        e--;
                }
                j++;
                while (j < N - 2 && nums[j - 1] == nums[j])
                    j++;
            }
            i++;
            while (i < N - 3 && nums[i - 1] == nums[i])
                i++;
        }
        return ans;
    }
}
/**
 * This problem is very important owing to the fact that it focuses on 
 * pointer manipulation in sorted arrays. 
 */