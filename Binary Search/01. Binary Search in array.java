/*
Company Tags:  Paytm
Practice Portal:
Geeksforgeeks:https://practice.geeksforgeeks.org/problems/who-will-win-1587115621/1
*/

/*
mid = (start+end)/2  can OVERFLOW while finding the mid if int is going out of int range
better use :
mid = start + (end-start)/2;
*/

class SearchElement{
    static int searchInSorted(int arr[], int n, int target)
    {
        int start = 0;
        int end = n-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (arr[mid] == target) {
                return 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
}

/*

Time Complexity:
The time complexity of Binary Search can be written as

T(n) = T(n/2) + c
The above recurrence can be solved either using Recurrence T ree method or Master method. It falls in case II of Master Method
and solution of the recurrence is Theta(Logn).

Time Complexity: O(logN)

Auxiliary Space: O(1) in case of iterative implementation. In case of recursive implementation, O(Logn) recursion call stack space.

Check: https://www.geeksforgeeks.org/binary-search/
*/