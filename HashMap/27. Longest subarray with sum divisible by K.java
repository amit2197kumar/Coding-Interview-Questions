/*
Company Tags:  
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1#
*/

class Solution{
    int longSubarrWthSumDivByK(int nums[], int n, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();  //<Sum, 1st-index>
        
        int sum = 0;
        map.put(0, -1);
        int rem = 0;
        int maxLen = 0;
        
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            rem = sum % k;
            
            if (rem < 0) {
                rem += k;
            }
            
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(rem, i);
            }
        }
        
        return maxLen;
    }
}
