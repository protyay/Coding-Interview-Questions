/**
 * https://practice.geeksforgeeks.org/problems/operations-on-binary-min-heap
 */
public class MinHeap {
    int[] harr;
    int capacity, heap_size;

    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int left(int i) {
        return (2 * i + 1);
    }

    int right(int i) {
        return (2 * i + 2);
    }

    // You need to write code for below three functions
    int extractMin() {
        // Your code here.
        if (heap_size == 0)
            return -1;
        if (heap_size == 1) {
            heap_size--;
            return harr[0];
        }
        // More than 1 elements exist
        int min = harr[0];
        harr[0] = harr[heap_size - 1];
        harr[heap_size - 1] = 0;
        --heap_size;
        // Re-organize the tree
        MinHeapify(0);

        return min;
    }

    void insertKey(int k) {
        // Your code here.
        if (harr.length == heap_size)
            return;
        int i = heap_size;
        harr[i] = k; // Maintain complete BT invariant
        while (i > 0 && harr[parent(i)] > harr[i]) {
            // Percolate up
            int temp = harr[parent(i)];
            harr[parent(i)] = harr[i];
            harr[i] = temp;

            i = parent(i);
        }
        heap_size++;
    }

    void deleteKey(int i) {
        // Your code here.
        if (i >= heap_size)
            return;
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    // Decrease key operation, helps in deleting the element
    void decreaseKey(int i, int new_val) {
        harr[i] = new_val;
        while (i != 0 && harr[parent(i)] > harr[i]) {
            int temp = harr[i];
            harr[i] = harr[parent(i)];
            harr[parent(i)] = temp;
            i = parent(i);
        }
    }

    /*
     * You may call below MinHeapify function in above codes. Please do not delete
     * this code if you are not writing your own MinHeapify
     */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i])
            smallest = l;
        if (r < heap_size && harr[r] < harr[smallest])
            smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}
