/*
Company Tags:  24*7 Innovation Labs Accolite Amazon Citrix D-E-Shaw FactSet Flipkart Hike Housing.com MetLife Microsoft
Morgan Stanley Ola Cabs Oracle Payu Samsung Snapdeal Teradata Visa Walmart Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
*/

// This problem can also be done Kadane algorithm. Check Array Dir

class Kadane{

    int maxSubarraySum(int arr[], int n){
        return maxSubarraySum(arr, 0, n-1);
    }

    int maxSubarraySum(int arr[], int start, int end) {
        if (start > end)
            return 0;

        if (start == end)
            return arr[start];

        int mid = (start + end)/2;

        return Math.max(maxMidCrossingSum(arr, start, mid, end),
                Math.max(maxSubarraySum(arr, start, mid),
                        maxSubarraySum(arr, mid + 1, end)));
    }

    int maxMidCrossingSum(int arr[], int start, int mid, int end) {

        int sum = 0;
        int leftSum = Integer.MIN_VALUE;

        for (int i=mid; i>=0; i--) {
            sum = sum + arr[i];
            if (sum > leftSum)
                leftSum = sum;
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;

        for (int i=mid+1; i<=end; i++) {
            sum = sum + arr[i];
            if (sum > rightSum)
                rightSum = sum;
        }

        return (Math.max(leftSum + rightSum, Math.max(leftSum, rightSum)));
    }
}


/*
Time Complexity: O(n log(n))

The Kadane’s Algorithm for this problem takes O(n) time. Therefore the Kadane’s algorithm is better than the Divide and Conquer approach,
but this problem can be considered as a good example to show power of Divide and Conquer. The above simple approach where we divide the array in two halves,
reduces the time complexity from O(n^2) to O(nLogn).
*/
