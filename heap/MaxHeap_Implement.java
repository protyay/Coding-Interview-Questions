import java.util.Arrays;

public class MaxHeap_Implement {
    // Building max-heap with iterative solution
    public void heapify(int[] arr) {
        if (arr.length == 1)
            return;
        int N = arr.length;
        int internal_nodes = N / 2 - 1; // 0 to N/2 - 1 // Internal nodes
        for (int i = internal_nodes; i >= 0; i--) {
            int L = 2 * i + 1;
            int R = 2 * i + 2;
            int largestIdx = i;
            if (L < N && arr[L] > arr[largestIdx])
                largestIdx = L;
            if (R < N && arr[R] > arr[largestIdx])
                largestIdx = R;
                
            if (largestIdx != i) {
                int temp = arr[i];
                arr[i] = arr[largestIdx];
                arr[largestIdx] = temp;
            }
        }
    }

    // Max heap with recursive solution;
    public void heapify_Recurse(int[] arr, int index) {
        int largest = index;
        int l = 2 * largest + 1;
        int r = 2 * largest + 2;
        if (l < arr.length && arr[l] > arr[largest])
            largest = l;
        if (r < arr.length && arr[r] > arr[largest])
            largest = r;

        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;

            heapify_Recurse(arr, largest);
        }
    }

    public static void main(String[] args) {
        MaxHeap_Implement heap = new MaxHeap_Implement();
        int[] input = { 3, 6, 4, 1, 19, 2, 3 };
        for (int i = input.length / 2 - 1; i >= 0; i--)
            heap.heapify(input);
        System.out.println("From iterative =" + Arrays.toString(input));
        int[] input1 = { 3, 6, 4, 1, 19, 2, 3 };
        for (int i = input1.length / 2 - 1; i >= 0; i--)
            heap.heapify_Recurse(input1, i);
        System.out.println("From Recursive =" + Arrays.toString(input1));
    }
}
