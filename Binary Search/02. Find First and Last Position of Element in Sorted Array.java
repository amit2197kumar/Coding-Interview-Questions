/*
Company Tags:   Amazon Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/who-will-win-1587115621/1
LeetCode: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[2];
        range[0] = firstOccurrence(nums, target);
        range[1] = lastOccurrence(nums, target);
        return range;
    }

    public int firstOccurrence(int[] nums, int target) {
        int n = nums.length;
        int first = -1;

        int start, end;
        start = 0;
        end = n-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                first = mid;
                end = mid - 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return first;
    }

    public int lastOccurrence(int[] nums, int target) {
        int n = nums.length;
        int last = -1;

        int start, end;
        start = 0;
        end = n-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                last = mid;
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return last;
    }
}

/*
Time Complexity : O(log n)
Auxiliary Space : O(1)
*/