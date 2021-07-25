import java.util.Arrays;

/**
 * Partition an array using a given pivot element
 */
public class ArrayPartition {
    public static void main(String[] args) {
        // Region defining - a. 0 - j-1 Smaller than or equal to pivot b. j to i-1
        // Greater than pivot
        // c. i to nums.length - Unknown - At each step we keep shrinking the unknown
        // space
        // int[] nums = { 7, 9, 4, 5, 8, 3, 6, 2, 1 };
        int[] nums = { 5, 7, 9, 1, 6, 8, 3, 5, 4, 5 };
        // expected - {1,2,3,4,5,6,7,8,9};
        ArrayPartition partition = new ArrayPartition();
        int k = 5;
        partition.partition(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    void partition(int[] nums, int pivot) {
        int smaller = 0, eq = 0, larger = nums.length - 1;

        while (eq <= larger) {
            if (nums[eq] > pivot) {
                swap(nums, eq, larger--);
            } else if (nums[eq] < pivot) {
                swap(nums, eq++, smaller++);
            } else
                eq++;
        }

    }

    void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
