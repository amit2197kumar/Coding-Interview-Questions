/*
Company Tags:   Accolite Amazon D-E-Shaw Microsoft Nagarro
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/majority-element/
LeetCode: https://leetcode.com/problems/majority-element/
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1
*/

/*
METHOD 1
Approach: The basic solution is to have two loops and keep track of the maximum count for all different elements.
If maximum count becomes greater than n/2 then break the loops and return the element having maximum count. If the maximum count doesn’t
become more than n/2 then the majority element doesn’t exist.
Time Complexity: O(n*n).

METHOD 2
Approach: The idea is to sort the array. Sorting makes similar elements in the array adjacent, so traverse the array and
update the count until the present element is similar to the previous one. If the frequency is more than half the size of the array, print the majority element.
ime Complexity: O(nlogn).

*/

/*
METHOD 3 (Using Moore’s Voting Algorithm):

Approach: This is a two-step process.
The first step gives the element that maybe the majority element in the array. If there is a majority element in an array,
then this step will definitely return majority element, otherwise, it will return candidate for majority element.
Check if the element obtained from the above step is majority element. This step is necessary as there might be no majority element.
*/

public class Solution {

    public int majorityElement(final int[] arr) {
        int candidate = findCandidate(arr);

        if (isMajority(arr, candidate)) {
            return candidate;
        }

        return -1;
    }

    public int findCandidate(int[] arr) {
        int n = arr.length;

        int count = 1;
        int index = 0;
        for (int i=1; i<n; i++) {
            if (arr[i] == arr[index])
                count++;
            else
                count--;

            if (count == 0) {
                index = i;
                count = 1;
            }
        }
        return arr[index];
    }

    boolean isMajority(int[] arr, int element) {
        int n = arr.length;
        int count = 0;

        for (int i=0; i<n; i++) {
            if (arr[i] == element)
                count++;
        }

        if (count >= n/2)
            return true;
        return false;
    }
}

/*
Time Complexity: O(n).
As two traversal of the array is needed, so the time complexity is linear.
Auxiliary Space: O(1).
As no extra space is required.
*/