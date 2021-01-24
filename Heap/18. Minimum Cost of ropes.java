/*
Company Tags: Amazon Goldman Sachs OYO Rooms
Practice Portal:
Geeksforgeeks : https://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
*/

/*************************************** Using PriorityQueue (geeksforgeeks) ******************************************/

class solve {

    long minCost(long arr[], int n) {
        PriorityQueue<Long> minheap = new PriorityQueue<Long>();
        for (Long value : arr) {
            minheap.add(value);
        }

        Long cost = 0L;
        while (minheap.size() > 1) {
            Long rope1 = minheap.poll();
            Long rope2 = minheap.poll();
            Long joinedRope = rope1 + rope2;
            cost += joinedRope;
            minheap.add(joinedRope);
        }

        return cost;
    }
}