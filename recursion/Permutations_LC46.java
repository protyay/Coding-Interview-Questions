import java.util.ArrayList;
import java.util.List;

public class Permutations_LC46 {
    // SDE problem. Understand time complexity -
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return ans;
        boolean[] visited = new boolean[nums.length];
        final List<Integer> temp = new ArrayList<>();

        dfs(nums, visited, temp);
        return ans;
    }

    private void dfs(int[] nums, boolean[] visited, List<Integer> temp) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;

            temp.add(nums[i]);
            dfs(nums, visited, temp);
            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
