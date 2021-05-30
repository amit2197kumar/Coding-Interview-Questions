/*
Company Tags: Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1
LeetCode: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
*/

/******************************** ONLY POSITIVE NUMBERS *******************************/

class Solution {
    public boolean canPair(int[] nums, int k) {
        HashMap<Integer, Integer> remainderCount = new HashMap<Integer, Integer>();
        for (Integer value : nums) {
            int remainder = value%k;
            
            int count = remainderCount.getOrDefault(remainder, 0);
            remainderCount.put(remainder, ++count);
        }
        
        for (Integer value : nums) {
            int remainder = value%k;
             
            if (remainder == 0) {
                int count = remainderCount.get(remainder);
                if (count%2 != 0) {
                    return false;
                }
            } else if (2 * remainder == k) {                 //Why are we doing 2*remainder == k?!
                int count = remainderCount.get(remainder);
                if (count%2 != 0) {
                    return false;
                }
            } else {
                int count = remainderCount.get(remainder);
                int countK = remainderCount.getOrDefault(k-remainder, 0);  //Why are we doing getOrDefault() & not get()
                
                if (count != countK) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

/**************************** POSITIVE + NEGATIVE NUMBERS *****************************/

class Solution {
    public boolean canArrange(int[] nums, int k) {
        HashMap<Integer, Integer> remainderCount = new HashMap<Integer, Integer>();
        for (Integer value : nums) {
            int remainder = value%k;
            
            if (remainder < 0) {
                remainder = remainder + k;  // Why we need to do this?!
            }
            
            int count = remainderCount.getOrDefault(remainder, 0);
            remainderCount.put(remainder, ++count);
        }
        
        for (Integer value : nums) {
            int remainder = value%k;
            if (remainder < 0) {
                remainder = remainder + k;          // Why we need to do this?!
            }
             
            if (remainder == 0) {
                int count = remainderCount.get(remainder);
                if (count%2 != 0) {
                    return false;
                }
            } else if (2 * remainder == k) {                 //Why are we doing 2*remainder == k?!
                int count = remainderCount.get(remainder);
                if (count%2 != 0) {
                    return false;
                }
            } else {
                int count = remainderCount.get(remainder);
                int countK = remainderCount.getOrDefault(k-remainder, 0);  //Why are we doing getOrDefault() & not get()
                
                if (count != countK) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

/*
Time Complexity: O(n) 
Space Complexity: O(n)
*/
