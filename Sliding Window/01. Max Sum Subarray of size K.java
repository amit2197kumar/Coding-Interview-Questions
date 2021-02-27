/*
Company Tags:   OYO Rooms
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
*/

class Solution{
    static int maximumSumSubarray(int k, ArrayList<Integer> arr,int N){

        if (k>N)
            return -1;

        int i, j;
        i = 0;
        j = 0;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (j=0; j<N; j++) {
            sum += arr.get(j);
            int windowSize = j - i + 1;
            if (windowSize == k) {
                maxSum = Math.max(maxSum, sum);
                sum -= arr.get(i);
                i++;
            }
        }

        return maxSum;
    }
}

/*
Time Complexity : O(n)
Auxiliary Space : O(1)
*/