import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = { 8, 5, 1, 3, 7, 2, 9, 6 };
        // int[] nums = {1,19,12,12,23,1};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private int partition(int[] nums, int lo, int hi, int pivotElement) {
        int start = lo, replaceIndex = lo;
        while (start < hi) {
            if (nums[start] > pivotElement)
                ++start;
            else {
                swap(nums, start++, replaceIndex++);
            }
        }
        swap(nums, hi, replaceIndex);
        return replaceIndex;
    }

    private void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }

    private void quickSort(int[] nums, int lo, int hi) {

        if (nums == null || lo >= hi)
            return;
        int pivotElement = nums[hi];
        int pivotIndex = partition(nums, lo, hi, pivotElement);
        quickSort(nums, lo, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, hi);
    }
}
