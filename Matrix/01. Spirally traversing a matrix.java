/*
Company Tags:  BrowserStack D-E-Shaw MakeMyTrip MAQ Software Microsoft Morgan Stanley Nagarro Nearbuy Oracle OYO Rooms Paytm Salesforce Snapdeal
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
*/

import java.util.Scanner;

public class Array_SpiralPrint {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] matrix2d = new int[row][col];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                matrix2d[i][j] = scanner.nextInt();
            }
        }

        printMatrix2D(matrix2d);
    }

    private static void printMatrix2D(int[][] matrix2d) {
        int left, right, top, bottom, count;
        left = 0;
        right = matrix2d[0].length - 1;
        top = 0;
        bottom = matrix2d.length - 1;
        count = (right + 1) * (bottom + 1);

        while (left <= right && top <= bottom) {

            //Print left to right ROW
            if (count > 0) {
                for(int i=left; i<=right; i++) {
                    System.out.print(matrix2d[top][i] + ", ");
                    count--;
                }
                top++;
            }

            //Print right top to bottom COLUMN
            if (count > 0) {
                for (int i=top; i<=bottom; i++) {
                    System.out.print(matrix2d[i][right] + ", ");
                    count--;
                }
                right--;
            }

            //Print right bottom to left ROW
            if (count > 0) {
                for (int i=right; i>=left; i--) {
                    System.out.print(matrix2d[bottom][i] + ", ");
                    count--;
                }
                bottom--;
            }

            //Print left bottom to top COLUMN
            if (count > 0) {
                for (int i=bottom; i>=top; i--) {
                    System.out.print(matrix2d[i][left] + ", ");
                    count--;
                }
                left++;
            }
        }
        System.out.print("END");
    }
}

/*
Complexity Analysis:

Time Complexity: O(m*n).
To traverse the matrix O(m*n) time is required.
Space Complexity: O(1).
No extra space is required.
*/