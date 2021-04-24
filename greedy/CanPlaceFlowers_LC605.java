import java.util.Arrays;

public class CanPlaceFlowers_LC605 {
    public boolean canPlaceFlowers(int[] nums, int n) {
        // Try out all possibilities
        // At each index, you would have two choice if nums[i] == 0 and nums[i-1]
        // and nums[i+1] == 0
        if (n == 0)
            return true;
        if (nums.length == 1)
            return nums[0] == 0 ? true : false;
        return recurse(nums, n, 0);
    }

    private boolean recurse(int[] nums, int n, int index) {

        // If we have crossed past the last index , we can make a decision
        if (index == nums.length) {
            if (n == 0)
                return true;
            return false;
        }
        // Cannot place flower here, we move on to the next flowerbed
        if (nums[index] == 1)
            return recurse(nums, n, index + 1);

        else {
            // This is a potential to place the flower

            if (index == 0) {
                // We only look right
                if (nums[index + 1] == 0) {
                    int[] updated = Arrays.copyOf(nums, nums.length);
                    updated[index] = 1;
                    return recurse(updated, n - 1, index + 1);
                } else
                    return recurse(nums, n, index + 1);
            } else if (index == nums.length - 1) {
                // We only look left
                if (nums[index - 1] == 0) {
                    int[] updated = Arrays.copyOf(nums, nums.length);
                    updated[index] = 1;
                    return recurse(updated, n - 1, index + 1);
                } else
                    return recurse(nums, n, index + 1);
            } else {
                if (nums[index + 1] == 0 && nums[index - 1] == 0) {
                    int[] updated = Arrays.copyOf(nums, nums.length);
                    updated[index] = 1;
                    return recurse(updated, n - 1, index + 1);
                } else
                    return recurse(nums, n, index + 1);
            }
        }
    }

    public static void main(String[] args) {
        CanPlaceFlowers_LC605 lc605 = new CanPlaceFlowers_LC605();
        int[] nums = { 0, 0 };
        int n = 2;
        boolean ans = lc605.canPlaceFlowers(nums, n);
        System.out.println("Ans =" + ans);
    }

    public boolean canPlaceFlowers_Greedy(int[] flowerbed, int n) {

        int validBeds = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                // When we have a single flowerbed
                if (i == flowerbed.length - 1) {
                    if (flowerbed[i] == 0) {
                        ++validBeds;
                    }
                } else {
                    if (flowerbed[i] == 1 || flowerbed[i + 1] == 1)
                        continue;
                    flowerbed[i] = 1;
                    validBeds++;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 1 || flowerbed[i - 1] == 1)
                    continue;
                flowerbed[i] = 1;
                validBeds++;
            } else {
                if (flowerbed[i] == 1 || flowerbed[i - 1] == 1 || flowerbed[i + 1] == 1)
                    continue;
                flowerbed[i] = 1;
                validBeds++;
            }
        }
        return validBeds >= n;
    }
}
