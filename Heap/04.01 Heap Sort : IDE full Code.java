import java.util.Scanner;

//Company Tags: 24*7 Innovation Labs Amazon Belzabar Intuit Oracle Samsung SAP Labs Visa
public class HeapSort {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter size of array : ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter array elements : ");
        for (int i=0; i<size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Array before buildHeap()");
        printArray(arr, size);

        buildHeap(arr, size);

        System.out.print("Array after buildHeap() and before heapSort()");
        printArray(arr, size);

        heapSort(arr, size);

        System.out.print("Array after heapSort()");
        printArray(arr, size);
    }

    static void buildHeap(int arr[], int n)
    {
        for (int index = n/2-1 ; index >= 0; index--) {
            heapify(arr, n, index);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int arr[], int arraySize, int index)
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

    static void heapSort(int arr[], int size) {
        for (int i=size-1; i>=0; i--) {
            swapArrayIndex(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    static void heapSort_anotherWay(int arr[], int size) {
        for (int i=0; i<size-1; i++) {
            remove(arr, size-i);
        }
    }

    static void remove(int arr[], int size) {
        int value = arr[0];
        arr[0] = arr[size-1];
        heapify(arr, size-1, 0);
        arr[size-1] = value;
    }

    static void swapArrayIndex(int arr[], int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    static int getLeftChildIndex(int index) {
        return 2*index+1;
    }

    static int getRightChildIndex(int index) {
        return 2*index+2;
    }

    static void printArray(int arr[], int size) {
        for (int i=0; i<size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
