/*
Company Tags: Amazon VMWare
Practice Portal: https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
*/

/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        int[] arrKth = new int[n] ;
        MinHeap minHeap = new MinHeap(k);

        for (int i=0; i<k-1; i++) {
            arrKth[i] = -1;
            insertMinHeap(arr[i], minHeap);

            ////UN_COMMENT to TEST
            //print(minHeap);
        }

        for (int i=k-1; i<n; i++) {
            if (getMinHeapTop(minHeap) < arr[i]) {
                if (i != 0)
                    arrKth[i] = getMinHeapTop(minHeap);
                minHeap.heap[0] = arr[i];
                minHeapify(minHeap, 0);

                ////UN_COMMENT to TEST
                //print(minHeap);
                if (i == 0)
                    arrKth[i] = getMinHeapTop(minHeap);
            } else {
                arrKth[i] = arrKth[i-1];
            }
        }

        return arrKth;
    }

    static class MinHeap {
        int[] heap;
        int currSize;
        int minSize;

        MinHeap(int minSize) {
            this.heap = new int[minSize];
            this.currSize = 0;
            this.minSize = minSize;
        }
    }

    static void print(MinHeap minHeap) {
        for (int i=0; i<minHeap.currSize; i++) {
            System.out.print(minHeap.heap[i] + " ");
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

    static void insertMinHeap(int value, MinHeap minHeap) {
        minHeap.heap[minHeap.currSize] = value;
        int currentHeapIndex = minHeap.currSize;

        while (minHeap.heap[currentHeapIndex] < minHeap.heap[getParent(currentHeapIndex)]) {
            swapElements(minHeap, currentHeapIndex, getParent(currentHeapIndex));
            currentHeapIndex = getParent(currentHeapIndex);
        }

        minHeap.currSize++;
    }

    static void swapElements(MinHeap minHeap, int index1, int index2) {
        int temp = minHeap.heap[index1];
        minHeap.heap[index1] = minHeap.heap[index2];
        minHeap.heap[index2] = temp;
    }

    static int getMinHeapTop(MinHeap minHeap) {
        return minHeap.heap[0];
    }

    static void minHeapify(MinHeap minHeap, int index) {
        int largestIndex = index;
        int leftIndex = getLeftChild(index);
        int rightIndex = getRightChild(index);


        if (leftIndex < minHeap.currSize && minHeap.heap[leftIndex] < minHeap.heap[largestIndex])
            largestIndex = leftIndex;

        if (rightIndex < minHeap.currSize && minHeap.heap[rightIndex] < minHeap.heap[largestIndex])
            largestIndex = rightIndex;

        if (largestIndex != index)
        {
            swapElements(minHeap, index, largestIndex);
            minHeapify(minHeap, largestIndex);
        }
    }
};