/*
Company Tags: Amazon Morgan Stanley Ola Cabs SAP Labs
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string/0
LeetCode: https://leetcode.com/problems/palindromic-substrings/
*/

// PARENT PROBLEM:

/************************************************** Recursive Solution ************************************************/

/*
Code: https://ide.geeksforgeeks.org/JZTNpa1ULM
Above code gives incorrect output for 3rd testcase "bcbcbc"
 */

/****************************************** Memoization Solution (Top-Down) *******************************************/

/*
Code: https://ide.geeksforgeeks.org/MopUO1uWcO
Above code gives incorrect output for 3rd testcase "bcbcbc"
 */

/************************************************** Bottom-up Solution ************************************************/

//See this to understand: https://youtu.be/XmSOWnL6T_I

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    static Scanner scan = new Scanner(System.in);
    public static void main (String[] args) {
        int tc = scan.nextInt();
        while(tc-- > 0) {

            int len = scan.nextInt();
            String str = scan.next();

            int count = countPalindrome(str, len);
            System.out.println(count);
        }
    }

    public static int countPalindrome(String str, int n) {

        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int gap=0; gap < n; gap++) {

            for (int i=0, j=gap; j<n; i++, j++) {

                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                        count++;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                        count++;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return count;
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n^2)
*/