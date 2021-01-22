/*
Company Tags: Amazon Cisco Hike OYO Rooms Walmart
Practice Portal: https://practice.geeksforgeeks.org/problems/kth-largest-element-in-a-stream2220/1
*/

/**********************************************MIN HEAP*********************************************/
class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        int[] result = new int[n];
        Heap heapObj = new Heap(k);
        int i=0;
        for(i=0;i<k;i++){
            heapObj.insertInHeap(arr[i]);
        }
        int l = 0;
        for(l=0;l<k-1;l++) result[l] = -1;
        result[l] = heapObj.heap[0];
        for(int j = k;j<n;j++){
            if(arr[j] > heapObj.heap[0]){
                heapObj.deleteFromHeap();
                heapObj.insertInHeap(arr[j]);
            }
            result[j] = heapObj.heap[0];
        }
        return result;
    }
}

class Heap{
    int[] heap;
    int size = 0;
    Heap(int k){
        heap = new int[k];
        size = 0;
    }

    public void deleteFromHeap() {
        heap[0] = heap[size - 1];
        heapifyDown(0);
        size--;
    }

    public void heapifyDown(int i) {
        int max = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if (left < size && heap[max] > heap[left])
            max = left;
        if (right < size && heap[max] > heap[right])
            max = right;
        if (i != max) {
            int temp = heap[max];
            heap[max] = heap[i];
            heap[i] = temp;
            heapifyDown(max);
        }
    }

    public void heapifyUp(int i) {
        int parent = (i - 1) / 2;
        while (parent >= 0 && heap[i] < heap[parent]) {
            int temp = heap[i];
            heap[i] = heap[parent];
            heap[parent] = temp;
            i = parent;
            parent = (parent - 1) / 2;
        }
    }

    public void insertInHeap(int number) {
        heap[size++] = number;
        heapifyUp(size - 1);
    }
}

/*
TIME Complexity:

Min Heap of size k to store k largest elements of stream.
The k'th largest element is always at root and can be found in O(1) time.
How to process a new element of stream?
Compare the new element with root of heap. If new element is smaller, then ignore it.
Otherwise replace root with new element and call heapify for the root of modified heap.
Time complexity of finding the k'th largest element is O(Logk).
*/


/******************************************** PriorityQueue ***********************************************/

class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        int[] ans = new int[n];
        int index = 0 ;
        for (int i=0; i<k-1; i++) {
            ans[index++] = -1;
        }

        for (int i=0; i<k; i++) {
            pQueue.add(arr[i]);
        }

        ans[index++] = pQueue.peek();

        for (int i=k; i<n; i++) {
            if (arr[i] > pQueue.peek()) {
                pQueue.poll();
                pQueue.add(arr[i]);
            }
            ans[index++] = pQueue.peek();
        }

        return ans;
    }
};

