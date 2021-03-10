/*
Company Tags:  Amazon
Practice Portal:
*/


// code: https://ide.geeksforgeeks.org/EmSmhxRvsx

import java.io.*;
import java.util.*;

class GFG {
    static Scanner scan = new Scanner(System.in);
    public static void main (String[] args) {
        int row = scan.nextInt();
        int col = scan.nextInt();

        int[][] grid = new int[row][col];
        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                grid[i][j] = scan.nextInt();
            }
        }

        printAllPathTopLeftToBottomRight(grid, 0, 0, row-1, col-1, "");
    }

    private static void printAllPathTopLeftToBottomRight(int[][] grid, int i, int j, int row, int col, String path) {
        if (i > row || j > col)
            return;

        if (i == row && j == col) {
            path = path + Integer.toString(grid[i][j]);
            System.out.println(path);
            return;
        }

        path = path + Integer.toString(grid[i][j]) + " -> ";
        printAllPathTopLeftToBottomRight(grid, i+1, j, row, col, path);
        printAllPathTopLeftToBottomRight(grid, i, j+1, row, col, path);
    }
}

/*
INPUT:
3 3
1 2 3
4 5 6
7 8 9

OUTPUT:
1 -> 4 -> 7 -> 8 -> 9
1 -> 4 -> 5 -> 8 -> 9
1 -> 4 -> 5 -> 6 -> 9
1 -> 2 -> 5 -> 8 -> 9
1 -> 2 -> 5 -> 6 -> 9
1 -> 2 -> 3 -> 6 -> 9
*/

/*
Time Complexity : O(2^(M*N)) ??!!
*/