/*
Company Tags:
Practice Portal:
Geeksforgeeks:
LeetCode:
*/

// PARENT PROBLEM: Longest Common Subsequence

/************************************************** Recursive Solution ************************************************/
/*
Insert: Recur for l1 and l2-1
Remove: Recur for l1-1 and l2
Replace: Recur for l1-1 and l2-1
*/
class Solution
{
    public int editDistance(String s, String t) {
        return editDistanceHelper(s, t, s.length(), t.length());
    }

    public int editDistanceHelper(String s1, String s2, int l1, int l2) {
        if (l1 == 0)
            return l2;
        if (l2 == 0)
            return l1;

        if (s1.charAt(l1-1) == s2.charAt(l2-1)) {
            return editDistanceHelper(s1, s2, l1-1, l2-1);
        } else {
            return Math.min(editDistanceHelper(s1, s2, l1, l2-1) + 1,
                    Math.min(editDistanceHelper(s1, s2, l1-1, l2) + 1,
                            editDistanceHelper(s1, s2, l1-1, l2-1) + 1));
        }
    }
}

/*
Time Complexity: O(3^Lengh_Of_1st_String)
*/

/****************************************** Memoization Solution (Top-Down) *******************************************/
/*
Insert: Recur for l1 and l2-1
Remove: Recur for l1-1 and l2
Replace: Recur for l1-1 and l2-1
*/
class Solution
{
    public int editDistance(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i=0; i<s.length()+1; i++) {
            for (int j=0; j<t.length()+1; j++) {
                dp[i][j] = -1;
            }
        }
        return editDistanceHelper(s, t, s.length(), t.length(), dp);
    }

    public int editDistanceHelper(String s1, String s2, int l1, int l2, int[][] dp) {
        if (l1 == 0)
            return l2;
        if (l2 == 0)
            return l1;

        if (dp[l1][l2] != -1) {
            return dp[l1][l2];
        }

        if (s1.charAt(l1-1) == s2.charAt(l2-1)) {
            dp[l1][l2] = editDistanceHelper(s1, s2, l1-1, l2-1, dp);
        } else {
            dp[l1][l2] = Math.min(editDistanceHelper(s1, s2, l1, l2-1, dp) + 1,
                    Math.min(editDistanceHelper(s1, s2, l1-1, l2, dp) + 1,
                            editDistanceHelper(s1, s2, l1-1, l2-1, dp) + 1));
        }

        return dp[l1][l2];
    }
}

/*
Time Complexity: O(l1 x l2)
Auxiliary Space: O(l1 x l2)
*/

/************************************************** Bottom-up Solution ************************************************/
/*
Insert: Recur for l1 and l2-1
Remove: Recur for l1-1 and l2
Replace: Recur for l1-1 and l2-1
*/
class Solution
{
    public int editDistance(String s1, String s2) {
        int row = s1.length()+1;
        int col = s2.length()+1;
        int[][] dp = new int[row][col];

        for (int i=0; i<row; i++) {
            dp[i][0] = i;
        }

        for (int j=0; j<col; j++) {
            dp[0][j] = j;
        }

        for (int i=1; i<row; i++) {
            for (int j=1; j<col; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + 1,
                            Math.min(dp[i][j-1] + 1,
                                    dp[i-1][j-1] + 1));
                }
            }
        }

        return dp[row-1][col-1];
    }
}

/*
Time Complexity: O(s1.length() x s2.lebgth())
Auxiliary Space: O(s1.length() x s2.lebgth())
*/
