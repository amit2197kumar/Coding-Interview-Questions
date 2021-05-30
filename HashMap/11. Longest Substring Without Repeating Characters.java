/*
Company Tags: Amazon Morgan Stanley Synopsys Microsoft
Practice Portal:
Geeksforgeeks : https://practice.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1
LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

// This problem belongs to VARIBALE size sliding window varient

class Solution {
    public int lengthOfLongestSubstring(String str) {

        int i=0, j=0;
        int maxLen = 0;
        Set<Character> set = new HashSet<>();

        for (j=0; j<str.length(); j++) {
            if (set.contains(str.charAt(j))) {
                while (set.contains(str.charAt(j))) {
                    set.remove(str.charAt(i));
                    i++;
                }
            }

            set.add(str.charAt(j));
            maxLen = Math.max(set.size(), maxLen);
        }
        return maxLen;
    }
}

/*
Time Complexity:  O(n)
Space Complexity: O(n) worstcase (think why?!!)
*/
