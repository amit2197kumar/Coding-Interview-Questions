/*
Company Tags:  
Practice Portal:
Leetcode: https://leetcode.com/problems/subarray-sums-divisible-by-k/
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();  //<Sum, count>
        
        int sum = 0;
        map.put(0, 1);
        int rem = 0;
        int count = 0;
        
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            rem = sum % k;
            
            if (rem < 0) {
                rem += k;
            }
            
            if (map.containsKey(rem)) {
                count += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }
        
        return count;
    }
}
