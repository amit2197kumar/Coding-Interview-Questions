/*
Company Tags:  Accolite Amazon Groupon MakeMyTrip Microsoft Qualcomm Samsung Visa Walmart Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0
LeetCode: https://leetcode.com/problems/longest-palindromic-substring/
*/

// PARENT PROBLEM: Longest Common Substring

/************************************************** Recursive Solution ************************************************/

/*
We can find the LENGTH of <Longest Palindrome substring> by the Recursive solution used in PARENT PROBLEM: Longest Common Substring
Check that once.
*/

//Another way is below, BUT above once is better to understand to make it into Bottom-up Solution
class Solution {
    public String longestPalindrome(String str) {
        return longestPalindromeHelper(str, 0, str.length() - 1, 0);
    }

    public int longestPalindromeHelper(String str, int start, int end, int count) {
        if (start > end)
            return count;

        if (start == end)
            return count + 1;

        int include = 0;
        int exclude = 0;

        if (str.charAt(start) == str.charAt(end)) {
            include = longestPalindromeHelper(str, start+1, end-1, count + 2);
        } else {
            exclude = Math.max(longestPalindromeHelper(str, start+1, end, count),
                    longestPalindromeHelper(str, start, end-1, count));
        }

        return Math.max(include, exclude);
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

/************************************************** Bottom-up Solution ************************************************/

class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        return longestPalindromicSubstring(s, sb.toString(), s.length(), sb.toString().length());
    }

    public String longestPalindromicSubstring(String s1, String s2, int p, int q) {
        int[][] arr = new int[p + 1][q + 1];
        int maxLen = 0;

        for (int row = 0; row < p + 1; row++) {
            for (int colomn = 0; colomn < q + 1; colomn++) {
                arr[row][colomn] = 0;
            }
        }

        String ans = "";
        for (int row = 1; row < p + 1; row++) {
            for (int colomn = 1; colomn < q + 1; colomn++) {
                if (s1.charAt(row - 1) != s2.charAt(colomn - 1)) {
                    arr[row][colomn] = 0;
                } else {
                    arr[row][colomn] = arr[row - 1][colomn - 1] + 1;
                }

                // Below logic is the only extra logic added on top of logic that we saw in PARENT PROBLEM: Longest Common Substring
                if (maxLen < arr[row][colomn]) {

                    String temp = s1.substring(row - arr[row][colomn], row);
                    StringBuilder revtemp = new StringBuilder(temp);
                    revtemp.reverse();

                    if (revtemp.toString().equals(temp)) {
                        maxLen = arr[row][colomn];
                        ans = temp;
                    }
                }
            }
        }
        return ans;
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(n^2)
*/