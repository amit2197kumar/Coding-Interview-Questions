/*
Company Tags: Amazon
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
*/

/****************************************** Using PriorityQueue (Geeksforgeeks) ********************************************/

import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcase = scan.nextInt();
        while(testcase-- > 0) {
            int arrSize = scan.nextInt();
            int k = scan.nextInt();

            int[] arr = new int[arrSize];
            for (int i=0; i<arrSize; i++) {
                arr[i] = scan.nextInt();
            }

            PriorityQueue<Integer> minheap = new PriorityQueue<>(k);

            for (int i=0; i<k; i++) {
                minheap.add(arr[i]);
            }

            for (int i=k; i<arrSize; i++) {
                minheap.add(arr[i]);
                arr[i-k] = minheap.poll();
            }

            while(minheap.size() > 0) {
                arr[arrSize-minheap.size()] = minheap.poll();
            }

            for (int i=0; i<arrSize; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

/****************************************** Using PriorityQueue (Geeksforgeeks) ********************************************/

class Solution
{
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k) {
        ArrayList<Integer> sortedArr = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k+1);
        
        for (int i=0; i<k; i++) {
            minHeap.add(arr[i]);
        }
        
        for (int i=k; i<num; i++) {
            minHeap.add(arr[i]);
            
            int currMin = minHeap.poll();
            sortedArr.add(currMin);
        }
        
        while (minHeap.size() != 0) {
            int min = minHeap.poll();
            sortedArr.add(min);
        }
        
        return sortedArr;
    }
}
