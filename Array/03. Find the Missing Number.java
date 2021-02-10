/*
Company Tags:   Accolite Adobe Amazon Cisco D-E-Shaw Intuit Microsoft Morgan Stanley Ola Cabs Payu Qualcomm Visa
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
*/

// Approach 1
class Solution {
    int MissingNumber(int arr[], int n) {

        int sum = 0;
        for (int i=1; i<=n; i++) {
            sum += i;
        }

        for (int i=0; i<n-1; i++) {
            sum -= arr[i];
        }

        return sum;
    }
}

// Approach 2
class Solution {
    int MissingNumber(int arr[], int n) {

        //Sum of natural numbers : n(n+1)/2
        int sum = (n * (n+1))/2;

        for(int i=0; i<n-1; i++)
            sum = sum - arr[i] ;

        return Math.abs(sum) ;
    }
}

// Approach 3 : BIT operator XOR : https://www.geeksforgeeks.org/find-the-missing-number/

////Time complexity: O(N)
