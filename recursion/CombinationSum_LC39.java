import java.util.ArrayList;
import java.util.List;

public class CombinationSum_LC39 {
    // SDE problem
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return ans;

        dfs(candidates, target, 0, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] nums, int target, int start, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                temp.add(nums[i]);
                dfs(nums, target - nums[i], i, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
/**
 * Time complexity - O(N^T/M + 1) - Total num of nodes in a tree of height T/M - T is target , M = 1. Can also 
 * be written as O(2^T)
 * 
 * SC - If we do not consider the auxiliary space for recursion, we would end up
 * with O(K) space O(K) * C , C being the total number of combinations.
 */
