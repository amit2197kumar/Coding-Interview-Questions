/*
Company Tags:  Amazon
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1
LeetCode: https://leetcode.com/problems/palindrome-partitioning-ii/
Interviewbit: https://www.interviewbit.com/problems/palindrome-partitioning-ii/

NOTE: Was able to submit on Interviewbit, TLE on Geeksforgeeks and LeetCode
*/

// PARENT PROBLEM: Matrix Chain Multiplication

/************************************************** Recursive Solution ************************************************/

/*
1. Find i, j value to be sent in argument
2. Find right base case for MCM function
3. How we will be breaking the k, from which range
4. what will be recursive call
5. Calculate the temp ans
*/

class Solution{
    static int palindromicPartition(String str) {
        if (checkPalindrom(str, 0, str.length()-1) == true)
            return 0;

        return palindromicPartitionHelper(str, 0, str.length()-1);
    }

    static int palindromicPartitionHelper(String str, int i, int j) {
        if (i>=j)
            return 0;

        if (checkPalindrom(str, i, j) == true)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int k=i; k<j; k++) {
            // i to k && k+1 to j
            int value = palindromicPartitionHelper(str, i, k) +
                    palindromicPartitionHelper(str, k+1, j) + 1;

            min = min<value ? min:value;
        }
        return min;
    }

    static boolean checkPalindrom(String str, int i, int j) {
        while (i<=j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

/*
1. Find i, j value to be sent in argument
2. Find right base case for MCM function
3. How we will be breaking the k, from which range
4. what will be recursive call
5. Calculate the temp ans
*/

class Solution{
    static int palindromicPartition(String str) {
        if (checkPalindrom(str, 0, str.length()-1) == true)
            return 0;

        int[][] dp = new int[str.length()+2][str.length()+2];
        for (int i=0; i<=str.length()+1; i++) {
            for (int j=0; j<=str.length()+1; j++) {
                dp[i][j] = -1;
            }
        }
        return palindromicPartitionHelper(str, 0, str.length()-1, dp);
    }

    static int palindromicPartitionHelper(String str, int i, int j, int[][] dp) {
        if (i>=j)
            return 0;

        if (checkPalindrom(str, i, j) == true)
            return 0;

        int min = Integer.MAX_VALUE;

        if (dp[i][j] != -1)
            return dp[i][j];

        for (int k=i; k<j; k++) {
            // i to k && k+1 to j
            int value = palindromicPartitionHelper(str, i, k, dp) +
                    palindromicPartitionHelper(str, k+1, j, dp) + 1;

            min = min<value?min:value;
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    static boolean checkPalindrom(String str, int i, int j) {
        while (i<=j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}

//Time Complexity: O(n^3)
//Auxiliary Space: O(n^2)
//Accepted solution of InterviewBit: https://ide.geeksforgeeks.org/sMKFPLbFrg

/************************************************** Bottom-up Solution ************************************************/

Evaluate Boolean Parenthesization/Expression To True
