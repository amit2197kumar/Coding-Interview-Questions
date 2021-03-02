/*
Practice Portal:
LeetCode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
Pepcoding: https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/buy-sell-stocks-transaction-fee-ita-official/ojquestion
*/

// Must Watch: https://youtu.be/GY0O57llkKQ

class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;

        if (days == 0)
            return 0;

        int preCooldown = 0, currCooldown = 0;

        int preBuy = -prices[0],currBuy=0;

        int preSell = Integer.MIN_VALUE, currSell=0;

        for(int i=1; i<days; i++) {

            currCooldown = Math.max(preCooldown,preSell);

            currBuy = Math.max(preBuy, preCooldown - prices[i]);

            currSell = preBuy + prices[i];

            preCooldown = currCooldown;
            preBuy = currBuy;
            preSell = currSell;
        }

        return Math.max(currCooldown, currSell);
    }
}

/*
Time Complexity: O(n)
Auxiliary Space: O(1)
*/