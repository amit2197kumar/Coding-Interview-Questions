/*
Company Tags:  
Practice Portal:
LeetCode: https://leetcode.com/problems/find-all-anagrams-in-a-string/
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();
        
        int k = p.length();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<k; i++) {
            char c = p.charAt(i);
            
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        int i=0, j=0;
        int count = map.size();
        
        while (j < s.length()) {
            char curr = s.charAt(j);
            
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                
                if (map.get(curr) == 0) {
                    count--;
                }
            }
            
            int windowSize = j-i+1;
            
            if (windowSize == k) {
                if (count == 0) {
                    list.add(i);
                }
                
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    
                    if (map.get(s.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return list;
    }
}
