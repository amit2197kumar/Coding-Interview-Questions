/*
Company Tags:  Amazon Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
*/

/*
ALgo:
1. caluculate a leftMax[] left -> right (max)
2. caluculate a rightMax[] left <- right (max)
3. find ans[] = min(leftMax, rightMax)
4. find sum of all index for =  ans[] - arr[]
 */

class Trap{
    // arr[] = {3,0,0,2,0,4}
    // lef[] = {3,3,3,3,3,4} left -> right (max)
    // rig[] = {4,4,4,4,4,4} left <- right (max)
    // res[] = {3,3,3,3,3,4} min(lef, rig)
    // res[] = {0,3,3,1,3,0} res[] - arr[]

    static int trappingWater(int arr[], int n) {

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = arr[0];
        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }

        rightMax[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        }

        int[] ans = new int[n];
        for (int i=0; i<n; i++) {
            ans[i] = Math.min(leftMax[i], rightMax[i]);
        }

        int sumArea = 0;
        for (int i=0; i<n; i++) {
            sumArea += ans[i] - arr[i];
        }

        return sumArea;
    }
}

/*
Time Complexity: O(n).
Only one traversal of the array is needed, So time Complexity is O(n).
Space Complexity: O(n).
Two extra array is needed each of size n.
*/

/*
Algo2:
Instead of maintaing two arrays of size n for storing left and right max of each element, maintain two variables to store the maximum
till that point. Since water trapped at any element = min(max_left, max_right) – arr[i]. Calculate water trapped on smaller element
out of A[lo] and A[hi] first and move the pointers till lo doesn’t cross hi.
*/

class Trap{
    static int trappingWater(int arr[], int n) {

        int left, right, leftMax, rightMax, result;
        left = 0;
        right = n-1;
        leftMax = Integer.MIN_VALUE;
        rightMax = Integer.MIN_VALUE;
        result = 0;

        while (left <= right) {
            if (arr[left] < arr[right]) {
                if (arr[left] > leftMax) {
                    leftMax = arr[left];
                } else {
                    result += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] > rightMax) {
                    rightMax = arr[right];
                } else {
                    result += rightMax - arr[right];
                }
                right--;
            }
        }

        return result;
    }
}

/*
Time Complexity: O(n).
Only one traversal of the array is needed.
Auxiliary Space: O(1).
As no extra space is required.
*/