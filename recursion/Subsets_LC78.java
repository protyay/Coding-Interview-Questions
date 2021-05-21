import java.util.ArrayList;
import java.util.List;

public class Subsets_LC78 {
    // SDE Repeat
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ans;

        dfs(nums, new ArrayList<>(), ans, 0);

        return ans;
    }

    // [1,2,3]
    private void dfs(int[] nums, List<Integer> temp, List<List<Integer>> ans, int start) {
        ans.add(new ArrayList<Integer>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            dfs(nums, temp, ans, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
/**
 * Exponential time complexity (N*2^N)
 */
