/*
Company Tags:  Amazon FactSet Microsoft Morgan Stanley Zoho Google
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/gas-station/
LeetCode: https://leetcode.com/problems/gas-station/
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/circular-tour/1
*/

/*
Must Read & watch:
1. https://youtu.be/wDgKaNrSOEI
2. https://afteracademy.com/blog/gas-station-problem
 */

public class Solution {

    public int canCompleteCircuit(final int[] gas, final int[] cost) {
        int n = gas.length;

        int gasTotal, costTotal;
        gasTotal = costTotal = 0;

        for (int i=0; i<n; i++) {
            gasTotal = gasTotal + gas[i];
            costTotal = costTotal + cost[i];
        }

        if (gasTotal < costTotal)
            return -1;

        int startPoint = 0;
        int tankCapacity = 0;
        for (int i=0; i<n; i++) {
            tankCapacity = tankCapacity + gas[i] - cost[i];
            if (tankCapacity < 0) {
                startPoint = i+1;
                tankCapacity = 0;
            }
        }

        return startPoint;
    }
}

/*
Complexity Analysis
Time Complexity: O(n)
Space Complexity: O(1)
 */