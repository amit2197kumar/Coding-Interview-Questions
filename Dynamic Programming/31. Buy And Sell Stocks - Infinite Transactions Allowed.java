/*
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ita-official/ojquestion
*/

/********************************************** THIS IS NOT A DP PROBLEM ************************************************/

/*
Buy Buy Sell Sell : Not allowed as overlapping of Buy-sell is their
Buy Sell Buy Sell : Only this Allowed
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int no = scan.nextInt();
        int[] arr = new int[no];

        for (int i=0; i<no; i++) {
            arr[i] = scan.nextInt();
        }

        int allProfits = 0;
        int buyday = 0;
        int sellday = 0;

        for (int i=1; i<no; i++) {

            if (arr[i] > arr[i-1]) {
                sellday++;
            } else {
                allProfits += arr[sellday] - arr[buyday];
                buyday = i;
                sellday = i;
            }
        }
        // Important to remeber this last allProfits addition
        allProfits += arr[sellday] - arr[buyday];

        System.out.println(allProfits);
    }
}

/*
Time Complexity: O(n)
Auxiliary Space: O(1)
*/

/*
Recommended Read :
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
*/