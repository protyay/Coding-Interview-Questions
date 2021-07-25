public class CountingSort_LC1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1)
            count[i]++;
        int index = 0;
        for (int i : arr2) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        // Remaining
        for (int i = 0; i < 1001; i++) {
            while (count[i]-- > 0)
                arr1[index++] = i;
        }
        return arr1;
    }
}
