/*
Company Tags:
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
*/

// PARENT PROBLEM: Longest Common Subsequence

/******************************************** USING LONGEST COMMON SUBSEQUENCE ****************************************/
/************************************************** Recursive Solution ************************************************/

class Solution
{
    public int minOperations(String str1, String str2)
    {
        int p = str1.length();
        int q = str2.length();

        int common = lcs(p, q, str1, str2);

        return (p-common) + (q-common);
    }

    public int lcs(int p, int q, String s1, String s2){
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

/******************************************** USING LONGEST COMMON SUBSEQUENCE ****************************************/
/****************************************** Memoization Solution (Top-Down) *******************************************/

class Solution
{
    public int minOperations(String str1, String str2)
    {
        int p = str1.length();
        int q = str2.length();

        int common = lcs(p, q, str1, str2);

        return (p-common) + (q-common);
    }

    public int lcs(int p, int q, String s1, String s2) {

        int[][] dp = new int[p+1][q+1];

        for (int i=0; i<p+1; i++) {
            for (int j=0; j<q+1; j++) {
                dp[i][j] = -1;
            }
        }

        return lcsHelper(p, q, s1, s2, dp);
    }

    public int lcsHelper(int p, int q, String s1, String s2, int[][] dp) {
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

/******************************************** USING LONGEST COMMON SUBSEQUENCE ****************************************/
/************************************************** Bottom-up Solution ************************************************/

class Solution
{
    public int minOperations(String str1, String str2)
    {
        int p = str1.length();
        int q = str2.length();

        int common = lcs(p, q, str1, str2);

        return (p-common) + (q-common);
    }

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

/************************************************** USING OWN METHORD *************************************************/
/************************************************** Recursive Solution ************************************************/

class Solution
{
    public int minOperations(String s1, String s2)
    {
        int p = s1.length();
        int q = s2.length();

        return minOperationsHelper(s1, s2, p, q);
    }

    public static int minOperationsHelper(String s1, String s2, int index1, int index2) {
        //if (index1 <=0 && index2 <=0) return 0;
        if (index1 == 0) return index2 ;
        if (index2 == 0) return index1 ;

        if (s1.charAt(index1-1) == s2.charAt(index2-1)) {
            return minOperationsHelper(s1, s2, index1-1, index2-1);
        } else {
            return Math.min(1 + minOperationsHelper(s1, s2, index1-1, index2),
                    1 + minOperationsHelper(s1, s2, index1, index2-1));
        }
    }
}

/************************************************** USING OWN METHORD *************************************************/
/****************************************** Memoization Solution (Top-Down) *******************************************/

class Solution
{
    public int minOperations(String s1, String s2)
    {
        int p = s1.length();
        int q = s2.length();

        int [][] dp = new int[p+2][q+2];
        for (int i=0; i<p+2; i++) {
            for (int j=0; j<q+2; j++) {
                dp[i][j] = -1;
            }
        }

        return minOperationsHelper(s1, s2, p, q, dp);
    }

    public static int minOperationsHelper(String s1, String s2, int index1, int index2, int[][] dp) {
        if (index1 == 0) return index2 ;
        if (index2 == 0) return index1 ;

        if (dp[index1][index2] != -1)
            return dp[index1][index2];

        if (s1.charAt(index1-1) == s2.charAt(index2-1)) {
            return minOperationsHelper(s1, s2, index1-1, index2-1, dp);
        } else {
            dp[index1][index2] = Math.min(1 + minOperationsHelper(s1, s2, index1-1, index2, dp),
                    1 + minOperationsHelper(s1, s2, index1, index2-1, dp));
        }
        return dp[index1][index2];
    }
}

/************************************************** USING OWN METHORD *************************************************/
/************************************************** Bottom-up Solution ************************************************/

class Solution
{
    public int minOperations(String s1, String s2)
    {
        int p = s1.length();
        int q = s2.length();

        int [][] dp = new int[p+1][q+1];

        for (int i=0; i<q+1; i++) {
            dp[0][i] = i;
        }
        for (int i=0; i<p+1; i++) {
            dp[i][0] = i;
        }

        for (int i=1; i<p+1; i++) {
            for (int j=1; j<q+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(1+dp[i-1][j], 1+dp[i][j-1]);
                }
            }
        }

        return dp[p][q];
    }
}

