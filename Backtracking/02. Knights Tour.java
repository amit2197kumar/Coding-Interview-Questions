/*
Company Tags: Amazon
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/online-java-foundation/recursion-backtracking/knights-tour-official/ojquestion
*/

/*
https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
*/

import java.util.Scanner;
public class KnightsTour {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        int row = scan.nextInt();
        int col = scan.nextInt();

        int[][] chess = new int[n][n];
        printKnightsTour(chess, row, col, 1); // 1 is the number of move
    }

    public static void printKnightsTour(int[][] chess, int currRow, int currCol, int upcomingMove){
        if(currRow < 0 || currCol < 0 || currRow >= chess.length || currCol >= chess.length || chess[currRow][currCol] != 0){
            return;
        } else if(upcomingMove == chess.length * chess.length){
            chess[currRow][currCol] = upcomingMove;
            displayBoard(chess);
            chess[currRow][currCol] = 0; // we undo what was done
            return;
        }

        chess[currRow][currCol] = upcomingMove;
        printKnightsTour(chess, currRow - 2, currCol + 1, upcomingMove + 1);
        printKnightsTour(chess, currRow - 1, currCol + 2 , upcomingMove + 1);
        printKnightsTour(chess, currRow + 1, currCol + 2 , upcomingMove + 1);
        printKnightsTour(chess, currRow + 2, currCol + 1 , upcomingMove + 1);
        printKnightsTour(chess, currRow + 2, currCol - 1 , upcomingMove + 1);
        printKnightsTour(chess, currRow + 1, currCol - 2 , upcomingMove + 1);
        printKnightsTour(chess, currRow - 1, currCol - 2 , upcomingMove + 1);
        printKnightsTour(chess, currRow - 2, currCol - 1 , upcomingMove + 1);

        chess[currRow][currCol] = 0; // we undo what was done
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}

/*
Time Complexity looks like:

- 1st move 8 possibilities
- From 2nd move <=7 possibilities, since we don't go back to same position.
-- There are 63 moves like 2nd move.

8 * 7 * 7 * ... * 7 (*7 is for 63 times)
= 8 * (7 ^ 63)
= 8 * (8-1) ^(64-1)
= 8 * (8-1) ^(r*c-1)
= 8 ^ (r*c) approx      -- r and c  are  # of rows & columns of matrix
*/