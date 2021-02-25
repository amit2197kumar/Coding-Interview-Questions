/*
Company Tags:  Accolite Adobe Amazon Directi Goldman Sachs Groupon InMobi MakeMyTrip Ola Cabs One97 Oracle Paytm Polycom SAP Labs Snapdeal TinyOwl Visa Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1
LeetCode: https://leetcode.com/problems/search-a-2d-matrix/
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0;
        int j = col-1;

        while ((i >= 0 && i < row) && (j >= 0 && j < col)) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}

/*
Time Complexity: O(n).
Only one traversal is needed, i.e, i from 0 to n and j from n-1 to 0 with at most 2*n steps.
The above approach will also work for m x n matrix (not only for n x n). Complexity would be O(m + n).
Space Complexity: O(1).
No extra space is required.
*/
