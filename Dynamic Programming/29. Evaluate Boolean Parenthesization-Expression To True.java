/*
Company Tags:  Amazon Linkedin Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1
Interviewbit: https://www.interviewbit.com/problems/evaluate-expression-to-true/
*/

// PARENT PROBLEM: Matrix Chain Multiplication

/************************************************** Recursive Solution ************************************************/

import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while (test-- > 0) {
            int num=sc.nextInt();
            String str=sc.next();
            System.out.println(booleanParenthesization(num, str, 0, str.length()-1, 'T'));
        }
    }

    //Think why we need the tORf in argument
    public static int booleanParenthesization(int num, String expression, int i, int j, char tORf) {
        if (i>j) return 0;
        if (i==j) {
            if (expression.charAt(i) == tORf) return 1;
            return 0;
        }
        int ans=0;
        for (int k=i+1; k<=j-1; k=k+2) {
            int leftT = booleanParenthesization(num, expression, i, k-1, 'T');
            int leftF = booleanParenthesization(num, expression, i, k-1, 'F');
            int rightT = booleanParenthesization(num, expression, k+1, j, 'T');
            int rightF = booleanParenthesization(num, expression, k+1, j, 'F');

            if (expression.charAt(k) == '&') {
                if(tORf == 'T') {
                    ans += leftT*rightT;
                } else {
                    ans += leftF*rightT + leftT*rightF + leftF*rightF;
                }
            }

            if (expression.charAt(k) == '|') {
                if(tORf == 'T') {
                    ans += leftT*rightT + leftT*rightF + rightT*leftF;
                } else {
                    ans += leftF*rightF;
                }
            }

            if (expression.charAt(k) == '^') {
                if(tORf == 'T') {
                    ans += leftT*rightF + leftF*rightT;
                } else {
                    ans += leftT*rightT + leftF*rightF;
                }
            }

        }
        return ans;
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/

import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while (test-- > 0) {
            int num=sc.nextInt();
            String str=sc.next();
            int[][][] dp=new int[str.length()+2][str.length()+1][3];
            for (int row=0;row<str.length()+1;row++) {
                for (int colomn=0;colomn<str.length()+1;colomn++) {
                    for (int d=0; d<2; d++) {
                        dp[row][colomn][d] = -1;
                    }
                }
            }
            System.out.println(booleanParenthesization(num, str, 0, str.length()-1, 'T', dp));
        }
    }

    //Think why we need the tORf in argument
    public static int booleanParenthesization(int num, String expression, int i, int j, char tORf, int[][][] dp) {
        if (i>j) return 0;
        if (i==j) {
            if (expression.charAt(i) == tORf) return 1;
            return 0;
        }
        int ans=0;

        if (tORf == 'T' && dp[i][j][0] != -1) {
            return dp[i][j][0];
        }

        if (tORf == 'F' && dp[i][j][1] != -1) {
            return dp[i][j][1];
        }

        for (int k=i+1; k<=j-1; k=k+2) {
            int leftT = booleanParenthesization(num, expression, i, k-1, 'T', dp);
            int leftF = booleanParenthesization(num, expression, i, k-1, 'F', dp);
            int rightT = booleanParenthesization(num, expression, k+1, j, 'T', dp);
            int rightF = booleanParenthesization(num, expression, k+1, j, 'F', dp);

            if (expression.charAt(k) == '&') {
                if(tORf == 'T') {
                    ans += leftT*rightT;
                } else {
                    ans += leftF*rightT + leftT*rightF + leftF*rightF;
                }
            }

            if (expression.charAt(k) == '|') {
                if(tORf == 'T') {
                    ans += leftT*rightT + leftT*rightF + rightT*leftF;
                } else {
                    ans += leftF*rightF;
                }
            }

            if (expression.charAt(k) == '^') {
                if(tORf == 'T') {
                    ans += leftT*rightF + leftF*rightT;
                } else {
                    ans += leftT*rightT + leftF*rightF;
                }
            }

        }

        if (tORf == 'T') {
            dp[i][j][0] = ans%1003;
        } else {
            dp[i][j][1] = ans%1003;
        }
        return ans%1003;
    }
}

//Time Complexity: O(n^3)
//Auxiliary Space: O(n^2)

/************************************************** Bottom-up Solution ************************************************/
