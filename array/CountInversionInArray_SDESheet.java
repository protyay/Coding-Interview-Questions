public class CountInversionInArray_SDESheet {
    public static void main(String[] args) {
        int[] nums = { 8, 4, 2, 1 };
        int count = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > prev) {
                ++count;
            }
            prev = nums[i];
        }
    }
}
