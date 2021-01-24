/*
Company Tags" Amazon Directi Flipkart
Practice Portal:
Geeksforgeeks : https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
LeetCode: https://leetcode.com/problems/sliding-window-maximum/
*/

/*************************************** Using PriorityQueue (geeksforgeeks) ******************************************/

class solve{
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i=0; i<k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i=k; i<n; i++) {
            list.add(maxHeap.peek());
            maxHeap.remove(arr[i-k]);
            maxHeap.add(arr[i]);
        }
        list.add(maxHeap.peek());

        return list;
    }
}

/*************************************** Using PriorityQueue (LeetCode) ******************************************/

//Time Limit Exceeded

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] ans = new int[nums.length - k + 1];
        int index = 0;

        for (int i=0; i<k; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i=k; i<nums.length; i++) {
            ans[index++] = maxHeap.peek();
            maxHeap.remove(nums[i-k]);
            maxHeap.add(nums[i]);
        }
        ans[index++] = maxHeap.peek();

        return ans;
    }
}