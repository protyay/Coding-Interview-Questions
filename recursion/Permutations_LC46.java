import java.util.ArrayList;
import java.util.List;

public class Permutations_LC46 {
    // SDE problem. Understand time complexity - 
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        if (nums.length == 1)
            ans.add(List.of(nums[0]));
        else
            dfs(nums, ans, new ArrayList<>(), visited);

        return ans;
    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> res, boolean[] visited) {
        if (res.size() == nums.length) {
            ans.add(new ArrayList<>(res));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (visited[i])
                    continue;
                visited[i] = true;
                res.add(nums[i]);
                dfs(nums, ans, res, visited);
                res.remove(res.size() - 1);
                visited[i] = false;
            }
        }
    }
}
