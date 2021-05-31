/*
Company Tags: Amazon Google SAP Labs
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
*/

class Solution {
    public int longestkSubstr(String str, int k) {
            int maxLen = -1;
            int i=0, j=0;
            
            HashMap<Character, Integer> map = new HashMap<>();
            
            for (j=0; j<str.length(); j++) {
                
                if (map.containsKey(str.charAt(j))) {
                    map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
                } else {
                    map.put(str.charAt(j), 1);
                }
                
                if (map.size() == k) {
                    int windowSize = j - i + 1;
                    maxLen = Math.max(maxLen ,windowSize);
                }
                
                if (map.size() > k) {
                    while (map.size() != k) {
                        char ch = str.charAt(i);
                        if (map.get(ch) == 1) {
                            map.remove(ch);
                        } else {
                            map.put(ch, map.get(ch) - 1);
                        }
                        i++;
                    }
                }
            }
            
            return maxLen;
    }
}

/*
Time Complexity: O(n) 
Space Complexity: O(1)
*/
