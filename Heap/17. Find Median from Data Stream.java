/*
Company Tags: Adobe Amazon Apple Belzabar D-E-Shaw Facebook Flipkart Google Intuit Microsoft Morgan Stanley Ola Cabs Oracle Samsung SAP Labs Yahoo
Practice Portal:
Geeksforgeeks : https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
LeetCode: https://leetcode.com/problems/find-median-from-data-stream/
*/

/*************************************** Using PriorityQueue (geeksforgeeks) ******************************************/

class FindMedian
{
    static PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minheap = new PriorityQueue<>();

    // Function to insert heap
    public static void insertHeap(int value)
    {
        if (maxheap.size()==0 || value < maxheap.peek()) {
            maxheap.add(value);
        } else {
            minheap.add(value);
        }
        balanceHeaps();
    }

    // Function to balance Heaps
    public static void balanceHeaps()
    {
        PriorityQueue<Integer> big_heap = maxheap.size() > minheap.size() ? maxheap : minheap;
        PriorityQueue<Integer> small_heap = maxheap.size() > minheap.size() ? minheap : maxheap;

        if (big_heap.size() - small_heap.size() > 1){
            small_heap.add(big_heap.poll());
        }
    }

    // function to getMedian
    public static double getMedian()
    {
        PriorityQueue<Integer> big_heap = maxheap.size() > minheap.size() ? maxheap : minheap;
        PriorityQueue<Integer> small_heap = maxheap.size() > minheap.size() ? minheap : maxheap;

        if (big_heap.size() == small_heap.size()) {
            return ((double) big_heap.peek() + small_heap.peek())/2;
        } else {
            return big_heap.peek();
        }
    }
}

/****************************************** Using PriorityQueue (LeetCode) ********************************************/

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> maxheap;
    PriorityQueue<Integer> minheap;

    public MedianFinder() {
        maxheap = new PriorityQueue<>(Collections.reverseOrder());
        minheap = new PriorityQueue<>();
    }

    public void addNum(int value) {
        if (maxheap.size()==0 || value < maxheap.peek()) {
            maxheap.add(value);
        } else {
            minheap.add(value);
        }
        balanceHeaps();
    }

    public void balanceHeaps() {
        PriorityQueue<Integer> big_heap = maxheap.size() > minheap.size() ? maxheap : minheap;
        PriorityQueue<Integer> small_heap = maxheap.size() > minheap.size() ? minheap : maxheap;

        if (big_heap.size() - small_heap.size() > 1){
            small_heap.add(big_heap.poll());
        }
    }

    public double findMedian() {
        PriorityQueue<Integer> big_heap = maxheap.size() > minheap.size() ? maxheap : minheap;
        PriorityQueue<Integer> small_heap = maxheap.size() > minheap.size() ? minheap : maxheap;

        if (big_heap.size() == small_heap.size()) {
            return ((double) big_heap.peek() + small_heap.peek())/2;
        } else {
            return big_heap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */