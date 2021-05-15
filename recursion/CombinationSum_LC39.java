import java.util.ArrayList;
import java.util.List;

public class CombinationSum_LC39 {
    // SDE problem
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, 0, res, target, new ArrayList<Integer>());
        return res;
    }

    // Expressing your choice is the best way to solve a recursion
    private void dfs(int[] candidates, int index, List<List<Integer>> res, int target, List<Integer> temp) {
        if (target < 0)
            return;
        if (index == candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        // If we can choose the element
        if (candidates[index] <= target) {
            temp.add(candidates[index]);
            dfs(candidates, index, res, target - candidates[index], temp);
            temp.remove(temp.size() - 1);
        }
        // Don't choose the element
        dfs(candidates, index + 1, res, target, temp);
    }
}
/**
 * Time complexity - O(2^N) * k - two possible ways for each array element and
 * for the leaf nodes, we would have to iterate through all the elements to
 * build the ans. That's another K factor, k being the average length of each of
 * the combination
 * 
 * SC - If we do not consider the auxiliary space for recursion, we would end up
 * with O(K) space O(K) * C , C being the total number of combinations.
 */
