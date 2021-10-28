/*
Company Tags:  
Practice Portal:
Leetcode: https://leetcode.com/problems/isomorphic-strings/
*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Boolean> used = new HashMap<>();
        
        for (int i=0; i<s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            
            if (map.containsKey(sChar)) {
                if (tChar != map.get(sChar)) {
                    return false;
                }
            } else {
                if (used.containsKey(tChar)) {
                    return false;
                }
                
                map.put(sChar, tChar);
                used.put(tChar, true);
            }
        }
        
        return true;
    }
}
