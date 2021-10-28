/*
Company Tags:  
Practice Portal:
LeetCode: https://leetcode.com/problems/word-pattern/
*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        
        if (pattern.length() != words.length) {
            return false;
        }
        
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Boolean> used = new HashMap<>();
        
        for (int i=0; i<pattern.length(); i++) {
            char curr = pattern.charAt(i);
            
            if (map.containsKey(curr) == false) {
                if (used.containsKey(words[i])) {
                    return false;
                }
                map.put(curr, words[i]);
                used.put(words[i], true);
            } else {
                String mappedWith = map.get(curr);
                if (mappedWith.equals(words[i]) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}
