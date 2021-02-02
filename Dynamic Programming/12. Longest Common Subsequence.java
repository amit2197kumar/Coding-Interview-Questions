/*
Company Tags:  Amazon Citrix MakeMyTrip Paytm VMWare
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
*/

// Longest Common Subsequence is a PARENT PROBLEM

/************************************************** Recursive Solution ************************************************/

// In recursion, at every index, we check if both charecter matches or not,
//  if matches then we count 1 and increase both index by 1
//  else we both in both subtrees/substrings recursivally

class LCS{
    //Recursive Solution
    static int lcs(int p, int q, String s1, String s2){

        //Base case
        if (p==0 || q ==0)
            return 0;

        if (s1.charAt(p-1) == s2.charAt(q-1)) {
            return lcs(p-1, q-1, s1, s2) + 1;
        } else {
            return Math.max(lcs(p-1, q, s1, s2),
                    lcs(p, q-1, s1, s2));
        }
    }
}

/*
Time Complexity: The time complexity of this recursive approach is exponential 2^n
Auxiliary Space: O(1). No external space used for storing values apart from the internal stack space.
*/

/****************************************** Memoization Solution (Top-Down) *******************************************/

/*
Recursive Solution can be converted into Memoization Solution
1. We pass a Memoization matrix with -1 filled.
2. Recursive Solution remain exactly same, just added one if() to check if we have alredy solved this subproblem,
if TRUE return its value directly,
if FALSE, then after getting ans save in the Memoization matrix.
*/

class LCS{
    //Memoization Solution (Top-Down) : Recursive Call + DP Matrix
    static int lcs(int p, int q, String s1, String s2) {

        int[][] dp = new int[p+1][q+1];
        for (int i=0; i<p+1; i++) {
            for (int j=0; j<q+1; j++) {
                dp[i][j] = -1;
            }
        }
        return lcsHelper(p, q, s1, s2, dp);
    }

    static int lcsHelper(int p, int q, String s1, String s2, int[][] dp) {
        //Base case
        if (p==0 || q ==0)
            return 0;

        if (dp[p][q] != -1)
            return dp[p][q];

        if (s1.charAt(p-1) == s2.charAt(q-1)) {
            dp[p][q] = lcsHelper(p-1, q-1, s1, s2, dp) + 1;
        } else {
            dp[p][q] = Math.max(lcsHelper(p-1, q, s1, s2, dp),
                    lcsHelper(p, q-1, s1, s2, dp));
        }
        return dp[p][q];
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n^2) (Apart from the internal stack space)
*/

/************************************************** Bottom-up Solution ************************************************/

/*
Memoization Solution (Top-Down) can be converted into Bottom-up Solution
ROW are always n i.e. Size of the array.
1. We create a Bottom-up DP matrix.
2. Bottom-up DP matrix inicialization is done based on Base condition for recursion
3. From Memoization Solution
    3.1. p -> i
    3.2. q -> j
*/

class LCS{

    //Bottom-up Solution
    static int lcs(int p, int q, String s1, String s2){

        int[][] dp = new int[p+1][q+1];
        for(int i=0; i<p+1; i++)
            dp[i][0] = 0;

        for(int j=0; j<q+1; j++)
            dp[0][j] = 0;

        for (int i=1; i<p+1; i++) {
            for (int j=1; j<q+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],
                            dp[i][j-1]);
                }
            }
        }
        return dp[p][q];
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n^2)
*/