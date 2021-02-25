/*
Company Tags:   Adobe Amazon Google Visa
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/peak-element/1
LeetCode: https://leetcode.com/problems/find-peak-element/
*/

// Q used : Binary Search on Answer (https://youtu.be/IZP_8-JZqhM?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2) *[CONCEPT]*


class Solution {
    public int findPeakElement(int[] nums) {

        if (nums.length == 1)
            return 0;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (mid > 0 && mid < nums.length - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else {
                    if (nums[mid] < nums[mid - 1]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            } else if (mid == 0) {
                if (nums[0] > nums[1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == nums.length - 1) {
                if (nums[nums.length - 1] > nums[nums.length - 2]) {
                    return nums.length - 1;
                } else {
                    return nums.length - 2;
                }
            }
        }

        return -1;
    }
}

// Time Complexity : O(Log n)