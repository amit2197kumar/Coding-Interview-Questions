/*
JAVA implementation on MAX-HEAP

Operation:
getMax(): O(1)
extractMax(): O(Log n)
insert(): O(Log n)

Min Heap vs. Max Heap: https://www.educative.io/edpresso/min-heap-vs-max-heap
*/

import java.util.Scanner;

public class MaxHeap {
    private int[] heap;
    private int heapCurrIndex;
    private int heapMaxSize;

    MaxHeap (int heapMaxSize) {
        this.heapMaxSize = heapMaxSize;
        this.heapCurrIndex = 0;
        heap = new int[heapMaxSize];

        // If Heap array start with 1, this.heapCurrIndex = 1; heap[0] = Integer.MAX_VALUE;
    }

    public int getParent(int index) {
        return (index-1)/2;
        // If heap array start with index 0 then parent will be at: (index-1)/2
        // If heap array start with index 1 then parent will be at: index/2
    }

    public int getLeftChild(int index) {
        return index*2 + 1;
        // If heap array start with index 0 then left child will be at: index * 2
        // If heap array start with index 1 then left child will be at: (index * 2) + 1
    }

    public int getRightChild(int index) {
        return index*2 + 2;
        // If heap array start with index 0 then right child will be at: (index * 2) + 1
        // If heap array start with index 1 then right child will be at: (index * 2) + 2
    }

    public boolean checkIsLeafNode(int index) {
        return (index >= (heapCurrIndex / 2) && index <= heapCurrIndex);
    }

    // Swaps two nodes of the heap
    public void swapElements(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void insertInHeap(int element) {
        if (heapCurrIndex >= heapMaxSize) {
            System.out.println("Heap is at its max size!! Create a new HEAP to insert new elements.");
            return;
        }

        heap[heapCurrIndex] = element;
        int currentHeapIndex = heapCurrIndex;

        while (heap[currentHeapIndex] > heap[getParent(currentHeapIndex)]) {
            swapElements(currentHeapIndex, getParent(currentHeapIndex));
            currentHeapIndex = getParent(currentHeapIndex);
        }
        heapCurrIndex++;
    }

    public void printHeap() {
        // This prints the index of heap array.
        for (int i=0; i<heapCurrIndex; i++) {
            System.out.print("[" + i + "]" + " ");
        }
        System.out.println();

        // This prints the data of heap array.
        for (int i=0; i<heapCurrIndex; i++) {
            System.out.print(" " + heap[i] + " ");
        }
        System.out.println();
    }

    // Function to heapify the node at index
    public void maxHeapify(int index) {
        if (!checkIsLeafNode(index)) {
            if (heap[index] < heap[getLeftChild(index)] || heap[index] < heap[getRightChild(index)]) {
                if (heap[getLeftChild(index)] < heap[getRightChild(index)]) {
                    swapElements(index, getRightChild(index));
                    maxHeapify(getRightChild(index));
                } else {
                    swapElements(index,getLeftChild(index));
                    maxHeapify(getLeftChild(index));
                }
            }
        }
    }

    public int removeFromHeap() {
        if (heapCurrIndex <= 0) {
            return -1;
        }

        int element = heap[0];
        //Think why we are doing --heapCurrIndex and not heapCurrIndex--
        heap[0] = heap[--heapCurrIndex];
        maxHeapify(0);
        return element;
    }

    public int deleteIndex(int index) {
        // Think why used heap_size-1 and not heap_size
        if (heapCurrIndex-1 < index) {
            return -1;
        }

        /*
        Algo:
        1. Replace index 1 element with Integer.MAX_VALUE
        2. Make it a HEAP (by check parent-child property)
        3. As its a HEAP, Integer.MAX_VALUE will come in TOP, i.e. 0 index
        4. extractMax();
        */

        int element = heap[index];
        heap[index] = Integer.MAX_VALUE;
        while(index > 0 && heap[getParent(index)] < heap[index]) {
            swapElements(index, getParent(index));
            index = getParent(index);
        }
        removeFromHeap();
        return element;
    }

    // builds the max-heap using the maxHeapify()
    // Not been used in current Code, but if we are given an array and we need to make that a heap
    // then we will be using this function.
    public void maxHeap() {
        for (int index = ((heapCurrIndex - 1) / 2); index >= 1; index--) {
            maxHeapify(index);
        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter size of array that stores the HEAP : ");
        int enterHeapMaxSize = scanner.nextInt();
        MaxHeap maxHeap = new MaxHeap(enterHeapMaxSize);

        while (true) {
            System.out.println("1. INSERT an element in MAX-HEAP");
            System.out.println("2. REMOVE an element from MAX-HEAP");
            System.out.println("3. DELETE an index(element) from MAX-HEAP Array");
            System.out.println("4. EXIT from program");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter the element you want to INSERT in heap : ");
                    int element = scanner.nextInt();
                    maxHeap.insertInHeap(element);
                    System.out.println("Current HEAP -> ");
                    maxHeap.printHeap();
                    break;
                case 2:
                    int value = maxHeap.removeFromHeap();
                    if (value != -1)
                        System.out.println("Removed element from the HEAP is : " + value);
                    else
                        System.out.println("HEAP is empty!!!");
                    System.out.println("Current HEAP -> ");
                    maxHeap.printHeap();
                    break;
                case 3:
                    System.out.print("Enter the INDEX you want to DELETE from the heap : ");
                    int index = scanner.nextInt();
                    int valueD  = maxHeap.deleteIndex(index);
                    if (valueD != -1)
                        System.out.println("Index : " + index + " been deleted from HEAP, its value was : " + valueD);
                    else
                        System.out.println("NO such INDEX present in the current HEAP array!!!");
                    maxHeap.printHeap();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
