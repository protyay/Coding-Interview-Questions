import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_LC40 {
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return ans;

        Arrays.sort(candidates);
        final List<Integer> temp = new ArrayList<>();
        dfs(candidates, target, 0, temp);
        return ans;

    }

    private void dfs(int[] nums, int target, int index, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;

            if (target - nums[i] >= 0) {
                temp.add(nums[i]);
                dfs(nums, target - nums[i], i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
