/*
Practice Portal:
LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/
Pepcoding: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-transaction-fee-ita-official/ojquestion
*/

/*
SOLUTION is quite tricky.
Highly recommend to watch this tutorial : https://youtu.be/pTQB9wbIpfU
Reach comment section of LeetCode solution: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/
*/

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;

        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < days; i++) {
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, hold + prices[i] - fee);
        }
        return cash;

    }
}

/*
Complexity Analysis
Time Complexity: O(N)O(N), where NN is the number of prices.
Space Complexity: O(1)O(1), the space used by cash and hold.
*/

/*
Recommended Read :
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems
*/




