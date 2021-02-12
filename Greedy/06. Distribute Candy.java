/*
Company Tags:  Amazon Flipkart Microsoft
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/distribute-candy/
*/

/*
Approch:
https://afteracademy.com/blog/distribute-candy-problem
*/

public class Solution {
    public int candy(int[] arr) {
        int n = arr.length;

        int minCandy = 0;

        int[] leftRight = new int[n];
        int[] rightLeft = new int[n];

        for (int i=0; i<n; i++) {
            leftRight[i] = 1;
            rightLeft[i] = 1;
        }

        for (int i=1; i<n; i++) {
            if (arr[i-1] < arr[i])
                leftRight[i] = leftRight[i-1] + 1;
        }

        for (int i=n-2; i>=0; i--) {
            if (arr[i+1] < arr[i])
                rightLeft[i] = rightLeft[i+1] + 1;
        }

        for (int i=0; i<n; i++) {
            int case1 = leftRight[i];
            int case2 = rightLeft[i];

            minCandy = minCandy + Math.max(case1, case2);
        }

        return minCandy;
    }
}

/*
Complexity Analysis:
Time Complexity: O(n)
Space Complexity: O(n)
*/