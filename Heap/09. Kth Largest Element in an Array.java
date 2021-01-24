/*
Company Tags: Amazon
Practice Portal:
LeetCode: https://leetcode.com/problems/kth-largest-element-in-an-array/
*/

/****************************************** Using PriorityQueue (LeetCode) ********************************************/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
        for (int i=0; i<nums.length; i++) {
            minHeap.add(nums[i]);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}