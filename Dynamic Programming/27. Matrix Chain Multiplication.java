/*
Company Tags:  FactSet Flipkart Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
LeetCode:
*/

// Matrix Chain Multiplication is a PARENT PROBLEM

/************************************************** Recursive Solution ************************************************/

/*
1. Find i, j value to be sent in argument
2. Find right base case for MCM function
3. How we will be breaking the k, from which range
4. what will be recursive call
*/

class Solution{
    static int matrixMultiplication(int N, int arr[])   {
        //Think why: we are sending argument i=1 and j=N-1
        return matrixMultiplicationHelper(arr, 1, N-1);
    }

    static int matrixMultiplicationHelper(int[] array, int i, int j) {

        //Think why: we are including equalTo also in (>=)
        if (i>=j)
            return 0;

        int minCost = Integer.MAX_VALUE;

        //Think why: In argument value of j is already last value arry index i.e. N-1
        //Still we are having condition (k<j) i.e. k goes till second last index
        //So in all : k runs from 1st index to second-last index
        //why are me skipping the 1st and last index elements ???
        for (int k=i; k<j; k++) {
            // breaks in 2 parts
            // i to k
            // k+1 to j
            // Think why?

            int tempCost = matrixMultiplicationHelper(array, i, k) +
                    matrixMultiplicationHelper(array, k+1, j) +
                    (array[i-1]*array[k]*array[j]);

            //Think why: we are getting  array[i-1]*array[k]*array[j] ?

            minCost = minCost<tempCost ? minCost:tempCost;
        }
        return minCost;
    }
}

/*
if for loop runs for : k=i to k=j-1
then break in 2 halfs as : i to k and k+1 to j

if for loop runs for : k=i+1 to k=j
then break in 2 halfs as : i to k-1 and k to j
*/

/****************************************** Memoization Solution (Top-Down) *******************************************/

/*
1. Find i, j value to be sent in argument
2. Find right base case for MCM function
3. How we will be breaking the k, from which range
4. what will be recursive call
5. Calculate the temp ans
*/

class Solution{
    static int matrixMultiplication(int N, int arr[])   {

        int[][] dp = new int[N+1][N+1];
        for (int i=0; i<N+1; i++) {
            for (int j=0; j<N+1; j++) {
                dp[i][j] = -1;
            }
        }


        //Think why: we are sending argument i=1 and j=N-1
        return matrixMultiplicationHelper(arr, 1, N-1, dp);
    }

    static int matrixMultiplicationHelper(int[] array, int i, int j, int[][] dp) {

        //Think why: we are including equalTo also in (>=)
        if (i>=j)
            return 0;

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int minCost = Integer.MAX_VALUE;

        //Think why: In argument value of j is already last value arry index i.e. N-1
        //Still we are having condition (k<j) i.e. k goes till second last index
        //So in all : k runs from 1st index to second-last index
        //why are me skipping the 1st and last index elements ???
        for (int k=i; k<j; k++) {
            // breaks in 2 parts
            // i to k
            // k+1 to j
            // Think why?

            int tempCost = matrixMultiplicationHelper(array, i, k, dp) +
                    matrixMultiplicationHelper(array, k+1, j, dp) +
                    (array[i-1]*array[k]*array[j]);

            //Think why: we are getting  array[i-1]*array[k]*array[j] ?

            minCost = minCost<tempCost ? minCost:tempCost;
        }
        dp[i][j] = minCost;
        return dp[i][j];
    }
}

/*
if for loop runs for : k=i to k=j-1
then break in 2 halfs as : i to k and k+1 to j

if for loop runs for : k=i+1 to k=j
then break in 2 halfs as : i to k-1 and k to j
*/

/************************************************** Bottom-up Solution ************************************************/
