/*
Company Tags: 24*7 Innovation Labs Amazon Belzabar Intuit Oracle Samsung SAP Labs Visa
Practice Portal: https://practice.geeksforgeeks.org/problems/heap-sort/1
*/


/***********************************
 void heapSort(int arr[], int n)  {
 buildHeap(arr, n);
 for (int i=n-1; i>=0; i--)  {
 swap(arr[0], arr[i]);
 heapify(arr, i, 0);
 }
 }
 ************************************/

class GfG
{
    void buildHeap(int arr[], int n)
    {
        for (int index = n/2-1 ; index >= 0; index--) {
            heapify(arr, n, index);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    void heapify(int arr[], int arraySize, int index)
    {
        int largestIndex = index;  // Initialize largestIndex as root
        int leftIndex = getLeftChildIndex(index);  // left = 2*i + 1
        int rightIndex = getRightChildIndex(index);  // right = 2*i + 2

        // if left child exists and has value greater then parent
        if (leftIndex < arraySize && arr[leftIndex] > arr[largestIndex])
            largestIndex = leftIndex;

        // if right child exists and has value greater then parent
        if (rightIndex < arraySize && arr[rightIndex] > arr[largestIndex])
            largestIndex = rightIndex;

        // If largestIndex is not root/parent
        if (largestIndex != index)
        {
            swapArrayIndex(arr, index, largestIndex);
            heapify(arr, arraySize, largestIndex); // recusrsively call Maxheapify for largest variable
        }
    }

    void swapArrayIndex(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    int getLeftChildIndex(int index) {
        return 2*index+1;
    }

    int getRightChildIndex(int index) {
        return 2*index+2;
    }
}

/*
Time Complexity: Time complexity of heapify is O(Logn). Time complexity of createAndBuildHeap() is O(n) and overall time complexity of Heap Sort is O(nLogn).
*/