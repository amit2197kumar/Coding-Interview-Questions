/*
Company Tags: Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
*/

// PARENT PROBLEM: Longest Increasing Subsequence
//Must Go through Longest Increasing Subsequence to understand this
//Must watch this to understand Q: https://youtu.be/jdfpGSSyN2I?list=PL-Jc9J83PIiEZvXCn-c5UIBvfT8dA-8EG

/************************************************** Recursive Solution ************************************************/
//NOT NEEDED, see Longest Increasing Subsequence
/****************************************** Memoization Solution (Top-Down) *******************************************/
//NOT NEEDED, see Longest Increasing Subsequence
/************************************************** Bottom-up Solution ************************************************/

class Solution
{
    public int LongestBitonicSequence(int[] nums) {
        // lis : Longest Increasing Subsequence
        // lds : Longest Decreasing Subsequence

        int size = nums.length;

        /****************Longest Increasing Subsequence****************/
        int[] lis = new int[size];
        for (int i=0; i<size; i++) {
            lis[i] = 1;
        }

        for (int i=1; i<size; i++) {
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j] && lis[i] <= lis[j]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        /***************************************************************/

        /****************Longest Decreasing Subsequence******************/
        int[] lds = new int[size];
        for (int i=0; i<size; i++) {
            lds[i] = 1;
        }

        for (int i=size-2; i>=0; i--) {
            for (int j=size-1; j>i; j--) {
                if (nums[i] > nums[j] && lds[i] <= lds[j]) {
                    lds[i] = lds[j] + 1;
                }
            }
        }
        /***************************************************************/

        /******************Longest Bitonic Subsequence*******************/

        //Check above video to understand why we doing this!!
        int maxLen = lis[0] + lds[0] -1;
        for (int i=1; i<size; i++) {
            if ((lis[i] + lds[i] -1) > maxLen) {
                maxLen = lis[i] + lds[i] -1;
            }
        }
        /***************************************************************/

        return maxLen;
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n)
*/
