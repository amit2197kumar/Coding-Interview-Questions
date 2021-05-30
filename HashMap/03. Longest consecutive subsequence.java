/*
Company Tags: Amazon Walmart Microsoft
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
LeetCode: https://leetcode.com/problems/longest-consecutive-sequence/submissions/
*/

class Solution {
    public int longestConsecutive(int[] arr) {
        int N = arr.length;
        if(N <= 1)
	        return N;
	        
	    PriorityQueue<Integer> minheap = new PriorityQueue<>();
	    for (Integer value : arr) {
	        minheap.add(value);
	    }
	    
	    int longestConsecutive = 1;
	    int curr_longestConsecutive = 1;
	    int prev = minheap.remove();
	    
	    while (minheap.size() > 0) {
	        int curr = minheap.remove();
	        if (curr - prev == 1) {
	            curr_longestConsecutive ++;
	        } else if (curr-prev > 1) { // Its very important to conseder repetition on array value.
	            curr_longestConsecutive = 1;
	        } 
	        
	        if (curr_longestConsecutive > longestConsecutive) {
	            longestConsecutive = curr_longestConsecutive;
	        }
	        
	        prev = curr;
	    }
	    
	    if (curr_longestConsecutive > longestConsecutive) {
	        longestConsecutive = curr_longestConsecutive;
	    }
	    
	    return longestConsecutive;
    }
}

/*
Time Complexity: O(n) 
Space Complexity: O(n)
*/
