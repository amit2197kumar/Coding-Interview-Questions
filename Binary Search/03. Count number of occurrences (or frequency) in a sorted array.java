/*
Company Tags:  Amazon MakeMyTrip Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1
*/

//PARENT PROBLEM: Find First and Last Position of Element in Sorted Array

class Solution {
    int count(int[] nums, int n, int target) {
        int[] range = new int[2];
        range[0] = firstOccurrence(nums, target);
        range[1] = lastOccurrence(nums, target);

        if (range[0] == -1 && range[1] == -1)
            return 0;
        else
            return range[1] - range[0] + 1;
    }

    int firstOccurrence(int[] nums, int target) {
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

    int lastOccurrence(int[] nums, int target) {
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
Time Complexity: O(Logn)
Programming Paradigm: Divide & Conquer
*/