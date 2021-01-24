/*
Company Tags: Amazon
Practice Portal:
LeetCode: https://leetcode.com/problems/top-k-frequent-elements/
*/

/****************************************** Using PriorityQueue (LeetCode) ***************************************/

class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer value : arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        PriorityQueue<Integer> minheap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });
        minheap.addAll(map.keySet());

        int[] ans = new int[k];
        int index = 0;
        while (minheap.size() > 0 && index < k) {
            ans[index++] = minheap.poll();;
        }

        return ans;
    }
}