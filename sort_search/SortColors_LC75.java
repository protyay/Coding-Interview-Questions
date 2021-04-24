public class SortColors_LC75 {
    public void sortColors(int[] nums) {
        int l = 0, m = 0, h = nums.length - 1;
        while (m < nums.length && m <= h) {
            if (nums[m] == 0) {
                swap(nums, m, l);
                m++;
                l++;
            } else if (nums[m] == 2) {
                swap(nums, m, h);
                h--;
            } else
                m++;
        }
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
/*
* The primary idea here is to understand that the low and mid starts from the left.
So, when we encounter a zero, we swap with left and increase both the pointers.
This is because we are sure we have the low pointer at the right index.
For high, when we swap we are not sure which value we get at the mid index after swapping.
Hence, we decrease the high pointer, because that is sure to contain a 2. We re-check the mid pointer
in the next iteration and decide accordingly.
 */