import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup_LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);// So that duplicate elements are adjacent;
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        dfs(nums, res, new ArrayList<>(), 0);

        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> temp, int index) {
        res.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            temp.add(nums[i]);
            dfs(nums, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
