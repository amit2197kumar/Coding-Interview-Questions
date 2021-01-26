/*
Company Tags:
Practice Portal:
LeetCode: https://leetcode.com/problems/target-sum/
*/

// PARENT PROBLEM: Count number of subset with given difference & Count of subsets with sum equal to X

/*
APPROCH:
It will be helpfull if we read this first: [Count number of subset with given difference]
Lets take an example first:

Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

If we see carefully, we can say that we are actully splitting the array in 2 subarrays
1st subarray that are with positive sign, 2nd subarray that are with negative sign
-1+1+1+1+1 = 3  -> [-1] + [+1+1+1+1]
+1-1+1+1+1 = 3  -> [-1] + [+1+1+1+1]
+1+1-1+1+1 = 3  -> [-1] + [+1+1+1+1]
+1+1+1-1+1 = 3  -> [-1] + [+1+1+1+1]
+1+1+1+1-1 = 3  -> [-1] + [+1+1+1+1]

We are actually breaking the array in 2 subarray, S1 and S2 (one is positive, one is negative)
and adding both we need to get the TARGET_SUM
So we can conclude that we want S1 - S2 = TARGET_SUM
This is the same problem that we discussed in [Count number of subset with given difference]
For rest of the approch, please read that file: 06.Count number of subset with given difference.md

*/

/************************************************** Recursive Solution ************************************************/

class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        if (target > sum)
            return 0;

        int subSetSum = (target + sum);
        if (subSetSum%2!=0)
            return 0;

        subSetSum = subSetSum/2;

        return subSetSumHelper(arr, subSetSum, arr.length);
    }

    //Recursive Solution
    public int subSetSumHelper(int[] arr, int sum, int currIndex) {
        if (currIndex <= 0) {
            if (sum == 0)
                return 1;
            else
                return 0;
        }

        if (sum >= arr[currIndex-1]) {
            return subSetSumHelper(arr, sum, currIndex-1) +
                    subSetSumHelper(arr, sum-arr[currIndex-1], currIndex-1);
        } else {
            return subSetSumHelper(arr, sum, currIndex-1);
        }
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

/************************************************** Bottom-up Solution ************************************************/
