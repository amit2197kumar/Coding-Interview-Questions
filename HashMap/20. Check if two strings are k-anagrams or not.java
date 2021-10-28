/*
Company Tags:  
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1
*/

class GfG
{
    boolean areKAnagrams(String s1, String s2, int k) {
        if (Math.abs(s1.length() - s2.length()) > k)
            return false;
            
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s1.length(); i++) {
            char curr = s1.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        
        for (int i=0; i<s2.length(); i++) {
            char curr = s2.charAt(i);
            if (map.getOrDefault(curr, 0) > 0) {
                map.put(curr, map.get(curr) - 1);
            }
        }
        
        int count = 0;
        for (char ch : map.keySet()) {
            count += map.get(ch);
        }
        
        if (count > k)
            return false;
        return true;
    }
}
