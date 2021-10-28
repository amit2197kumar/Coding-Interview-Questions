/*
Company Tags:  
Practice Portal:
LeetCode: https://leetcode.com/problems/contiguous-array/
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1
*/

class Solution {
    public int findMaxLength(int[] nums) {
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, -1); //<Sum, index>
        
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            
            if (map.containsKey(sum)) {
                int lastIndex = map.get(sum);
                int currLen = i - lastIndex;
                
                maxLen = Math.max(maxLen, currLen);
            } else {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
}
