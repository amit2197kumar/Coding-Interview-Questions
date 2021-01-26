/*
Company Tags: Amazon Flipkart
Practice Portal:
Geeksforgeeks: NA
LeetCode: NA
Artical: https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
*/

// PARENT PROBLEM: Subset Sum Problem & 0-1 Knapsack

/************************************************** Recursive Solution ************************************************/
// In recursion, at every index, we have 2 choices, either to pick the current VAL or leave the current VAL

//Recursive Solution
//Full Solution: https://ide.geeksforgeeks.org/4MpJnTMMRT
//NOTE : THE FOLLOWING SOLUTION WILL ONLY WORK FOR ARRAY WHOSE ELEMENTS ARE NON ZERO & POSITIVE
public static int subSetSum(int [] arr, int sum, int currIndex) {
    if (sum == 0)
        return 1;

    if (currIndex <= 0)
        return 0;

    if (sum >= arr[currIndex-1]) {
        return subSetSum(arr, sum, currIndex-1) +
               subSetSum(arr, sum-arr[currIndex-1], currIndex-1);
    } else {
        return subSetSum(arr, sum, currIndex-1);
    }
}

/****************************************** Memoization Solution (Top-Down) *******************************************/
/*
Recursive Solution can be converted into Memoization Solution
1. We pass a Memoization matrix with -1 filled.
2. Recursive Solution remain exactly same, just added one if() to check if we have alredy solved this subproblem,
if TRUE return its value directly,
if FALSE, then after getting ans save in the Memoization matrix.
*/

//Memoization Solution (Top-Down) : Recursive Call + DP Matrix
//Full Solution: https://ide.geeksforgeeks.org/tiPw4m5pKk
//NOTE : THE FOLLOWING SOLUTION WILL ONLY WORK FOR ARRAY WHOSE ELEMENTS ARE NON ZERO & POSITIVE
public static int subSetSum(int [] arr, int sum, int currIndex, int[][] dp) {
    if (sum == 0)
        return 1;
    if (currIndex <= 0)
        return 0;

    if (dp[currIndex][sum] != -1)
        return dp[currIndex][sum];

    if (sum >= arr[currIndex-1]) {
        dp[currIndex][sum] = subSetSum(arr, sum, currIndex-1, dp) +
                             subSetSum(arr, sum-arr[currIndex-1], currIndex-1, dp);
    } else {
        dp[currIndex][sum] = subSetSum(arr, sum, currIndex-1, dp);
    }

    return dp[currIndex][sum];
}

/************************************************** Bottom-up Solution ************************************************/
/*
Memoization Solution (Top-Down) can be converted into Bottom-up Solution
ROW are always n/size i.e. Size of the array.
1. We create a Bottom-up DP matrix.
2. Bottom-up DP matrix inicialization is done based on Base condition for recursion
3. From Memoization Solution
    3.1. n -> i
    3.2. W -> j
*/

//Bottom-up Solution
//Full Solution: https://ide.geeksforgeeks.org/7F0sQU7AUh
//NOTE : THE FOLLOWING SOLUTION WILL ONLY WORK FOR ARRAY WHOSE ELEMENTS ARE NON ZERO & POSITIVE
public static int subSetSum(int [] arr, int sum, int index) {
    int row = index+1;
    int col = sum+1;

    int[][] dp = new int[row][col];

    for (int i=0; i<row; i++)
        dp[i][0] = 1;

    for (int j=1; j<col; j++)
        dp[0][j] = 0;


    for (int i=1; i<row; i++) {
        for (int j=1; j<col; j++) {
            if ( j >= arr[i-1]) {
                dp[i][j] = dp[i-1][j] +
                           dp[i-1][j-arr[i-1]];
            } else {
                dp[i][j] = dp[i-1][j];
            }
        }
    }

    return dp[row-1][col-1];
}