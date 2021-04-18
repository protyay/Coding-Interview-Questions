public class FindFirstNLast_LC34 {
  public int[] searchRange(int[] nums, int target) {
    int leftMost = searchRange(nums, target, true);
    int rightMost = searchRange(nums, target, false);
    return new int[] { leftMost, rightMost };
  }

  private int searchRange(int[] nums, int target, boolean left) {
    int start = 0, end = nums.length - 1;
    int index = -1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] == target) {
        index = mid;
        if (left)
          end = mid - 1;
        else
          start = mid + 1;
      } else if (target < nums[mid])
        end = mid - 1;
      else
        start = mid + 1;
    }
    return index;
  }
}
