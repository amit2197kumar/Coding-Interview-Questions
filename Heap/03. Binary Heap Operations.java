/*
Company Tags: Amazon Ola Cabs Samsung Synopsys Walmart
Practice Portal: https://practice.geeksforgeeks.org/problems/operations-on-binary-min-heap/1
*/


/************************************************** START ********************************************************/

// User function Template for Java
class MinHeap {
    int[] harr;
    int capacity;
    int heap_size;

    MinHeap(int cap) {
        heap_size = 0;
        capacity = cap;
        harr = new int[cap];
    }
    int parent(int i) { return (i - 1) / 2; }
    int left(int i) { return (2 * i + 1); }
    int right(int i) { return (2 * i + 2); }

    // THIS funtion() WAS WRITTEN BY ME
    int extractMin() {

        if (heap_size <= 0) {
            return -1;
        }

        int element = harr[0];
        harr[0] = harr[--heap_size];
        MinHeapify(0);
        return element;
    }

    // THIS funtion() WAS WRITTEN BY ME
    void insertKey(int k) {
        harr[heap_size] = k;
        int currentHeapIndex = heap_size;

        while (harr[currentHeapIndex] < harr[parent(currentHeapIndex)]) {
            swapElements(currentHeapIndex, parent(currentHeapIndex));
            currentHeapIndex = parent(currentHeapIndex);
        }
        heap_size++;
    }

    // THIS funtion() WAS WRITTEN BY ME
    void deleteKey(int i) {
        // Think why used heap_size-1 and not heap_size
        if (heap_size-1 < i) {
            return;
        }

        /*
        Algo:
        1. Replace index 1 element with Integer.MIN_VALUE
        2. Make it a HEAP (by check parent-child property)
        3. As its a HEAP, Integer.MIN_VALUE will come in TOP, i.e. 0 index
        4. extractMin();
        */

        harr[i] = Integer.MIN_VALUE;
        while(i > 0 && harr[parent(i)] > harr[i]) {
            swapElements(i, parent(i));
            i = parent(i);
        }
        extractMin();
    }

    // THIS funtion() WAS ADDED BY ME
    // Swaps two nodes of the harr
    void swapElements(int index1, int index2) {
        int temp = harr[index1];
        harr[index1] = harr[index2];
        harr[index2] = temp;
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

    /* You may call below MinHeapify function in
      above codes. Please do not delete this code
      if you are not writing your own MinHeapify */
    void MinHeapify(int i) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && harr[l] < harr[i]) smallest = l;
        if (r < heap_size && harr[r] < harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MinHeapify(smallest);
        }
    }
}

/************************************************** END ********************************************************/