/*
Company Tags:  24*7 Innovation Labs Accolite Amazon Citrix D-E-Shaw FactSet Flipkart Hike Housing.com MetLife Microsoft
Morgan Stanley Ola Cabs Oracle Payu Samsung Snapdeal Teradata Visa Walmart Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
*/

// This problem can also be done in Divide and Conquer algorithm. Check Divide and Conquer Dir
class Kadane{

    int maxSubarraySum(int arr[], int n){
        int maxSum, currSum;
        maxSum = Integer.MIN_VALUE;
        currSum = 0;

        for (int i=0; i<n; i++) {
            currSum = currSum + arr[i];

            if (currSum > maxSum)
                maxSum = currSum;

            if (currSum < 0)
                currSum = 0;
        }

        return maxSum;
    }
}

/*
Time Complexity: O(n)
Algorithmic Paradigm: Dynamic Programming

This problem can done using Divide and Conquer algorithm in O(n log(n)) complexity
*/