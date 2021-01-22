/*
Company Tags: ABCO Accolite Amazon Cisco Hike Microsoft Snapdeal VMWare
Practice Portal: https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
*/

public static int kthSmallest(int[] arr, int l, int r, int k) {

        MaxHeap maxHeap = new MaxHeap(k);
        for (int i=0; i<k; i++) {
        insertMaxHeap(arr[i], maxHeap);
        //UN_COMMENT to TEST
        //print(maxHeap);
        }

        for (int i=k; i<=r; i++) {
        if (getMaxHeapTop(maxHeap) > arr[i]) {
        maxHeap.heap[0] = arr[i];
        maxHeapify(maxHeap, 0);

        //UN_COMMENT to TEST
        //print(maxHeap);
        }
        }
        return getMaxHeapTop(maxHeap);
        }

static class MaxHeap {
    int[] heap;
    int currSize;
    int maxSize;

    MaxHeap(int maxSize) {
        this.heap = new int[maxSize];
        this.currSize = 0;
        this.maxSize = maxSize;
    }
}

    static void print(MaxHeap maxHeap) {
        for (int i=0; i<maxHeap.currSize; i++) {
            System.out.print(maxHeap.heap[i] + " ");
        }
        System.out.println();
    }

    static int getParent(int index) {
        return (index-1)/2;
    }

    static int getLeftChild(int index) {
        return 2*index + 1;
    }

    static int getRightChild(int index) {
        return 2*index + 2;
    }

    static void insertMaxHeap(int value, MaxHeap maxHeap) {
        maxHeap.heap[maxHeap.currSize] = value;
        int currentHeapIndex = maxHeap.currSize;

        while (maxHeap.heap[currentHeapIndex] > maxHeap.heap[getParent(currentHeapIndex)]) {
            swapElements(maxHeap, currentHeapIndex, getParent(currentHeapIndex));
            currentHeapIndex = getParent(currentHeapIndex);
        }

        maxHeap.currSize++;
    }

    static void swapElements(MaxHeap maxHeap, int index1, int index2) {
        int temp = maxHeap.heap[index1];
        maxHeap.heap[index1] = maxHeap.heap[index2];
        maxHeap.heap[index2] = temp;
    }

    static int getMaxHeapTop(MaxHeap maxHeap) {
        return maxHeap.heap[0];
    }

    static void maxHeapify(MaxHeap maxHeap, int index) {
        int largestIndex = index;
        int leftIndex = getLeftChild(index);
        int rightIndex = getRightChild(index);


        if (leftIndex < maxHeap.currSize && maxHeap.heap[leftIndex] > maxHeap.heap[largestIndex])
            largestIndex = leftIndex;

        if (rightIndex < maxHeap.currSize && maxHeap.heap[rightIndex] > maxHeap.heap[largestIndex])
            largestIndex = rightIndex;

        if (largestIndex != index)
        {
            swapElements(maxHeap, index, largestIndex);
            maxHeapify(maxHeap, largestIndex);
        }
    }

/*
TIME Complexity:
WIll update!!!
*/