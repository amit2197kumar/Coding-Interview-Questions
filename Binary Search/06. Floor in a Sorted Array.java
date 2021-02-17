/*
Company Tags:    Amazon
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
*/

class FloorSearch{

    static int findFloor(long arr[], int n, long target)
    {
        int start = 0;
        int end = n-1;
        int pivot = -1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (arr[mid] <= target) {
                pivot = mid;
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            }
        }

        return pivot;
    }
}

// Time Complexity : O(Log n)