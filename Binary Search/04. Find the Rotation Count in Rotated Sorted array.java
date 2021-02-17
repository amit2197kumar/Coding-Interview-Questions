/*
Company Tags:   ABCO Amazon
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/rotation4723/1
*/

//NOTE : All the integers of arr/nums are unique.

class Solution {
    int findKRotation(int arr[], int n) {
        //Case: array is already sorted
        if(arr[0] < arr[n-1])
            return 0;

        int start = 0;
        int end = n-1;

        int mid, next, prev;

        while(start <= end){
            mid = start + (end - start)/2;

            //very important to understand why we doing %n
            next = (mid + 1) % n;
            prev = (mid + n-1) % n;

            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev])
                return mid;
            else if(arr[mid] > arr[end])
                start = mid + 1;
            else if(arr[mid] < arr[end])
                end = mid - 1;
        }
        return -1;
    }
}

// Time Complexity : O(Log n)

