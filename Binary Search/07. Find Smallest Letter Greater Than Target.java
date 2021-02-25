/*
Company Tags:    Amazon
Practice Portal:
LeetCode: https://leetcode.com/problems/find-smallest-letter-greater-than-target/
*/

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length-1;
        int pivot = -1;

        while (start <= end) {
            int mid = start + (end - start)/2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                pivot = mid;
                end = mid - 1;
            }
        }

        if (pivot == -1)
            return letters[0];

        return letters[pivot];
    }
}

// Time Complexity : O(Log n)