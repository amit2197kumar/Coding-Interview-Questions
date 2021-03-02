/*
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-and-sell-stocks-ota-official/ojquestion
*/

/********************************************** THIS IS NOT A DP PROBLEM ************************************************/

/************************************************** Approach 01 ************************************************/

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

        int[] rightGreatest = rightGreatestElement(arr, no);

        int maxDiff = Integer.MIN_VALUE;
        for (int i=0; i<no; i++) {
            maxDiff = Math.max(maxDiff, rightGreatest[i] - arr[i]);
        }

        System.out.println(maxDiff);
    }

    public static int[] rightGreatestElement(int[] arr, int len) {
        int[] rightGreatest = new int[len];

        int max = arr[len-1];
        rightGreatest[len-1] = arr[len-1];
        for (int i=len-2; i>=0; i--) {
            rightGreatest[i] = max;
            max = Math.max(max, arr[i]);
        }

        return rightGreatest;
    }

}

/*
Time Complexity: O(n)
Auxiliary Space: O(n)
*/

/************************************************** Approach 02 ************************************************/

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

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0; i<no; i++) {
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }

        System.out.println(maxProfit);
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