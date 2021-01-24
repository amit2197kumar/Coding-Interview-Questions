/*
Company Tags: Amazon
Practice Portal:
LeetCode: https://leetcode.com/problems/k-closest-points-to-origin/
*/

/****************************************** Using PriorityQueue (LeetCode) ********************************************/

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i=0; i<stones.length; i++) {
            maxHeap.add(stones[i]);
        }
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 == stone2)
                continue;
            else {
                maxHeap.add(stone1-stone2);
            }
        }
        if (maxHeap.size() == 0)
            return 0;
        else
            return maxHeap.peek();
    }
}