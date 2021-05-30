/*
Company Tags:  Amazon Google MakeMyTrip Streamoid Technologies Microsoft Media.net
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1
LeetCode: https://leetcode.com/problems/minimum-window-substring/
*/

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i=0; i<t.length(); i++) {
            char character = t.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        //System.out.println(map);
        
        String subString = "";
        int fast = -1;
        int slow = -1;
        int count = t.length();
        int currCount = 0;
        HashMap<Character, Integer> currMap = new HashMap<Character, Integer>();
        
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            // Aquire
            while (fast < s.length() - 1 && currCount < count) {
                fast++;
                char currChar = s.charAt(fast);
                currMap.put(currChar, currMap.getOrDefault(currChar, 0) + 1);
                
                if (currMap.get(currChar) <= map.getOrDefault(currChar, 0)) {
                    currCount++;
                }
                flag1 = true;
            }
            
            // Collect Ans & Release
            while (slow < fast && currCount == count) {
                String currSubString = s.substring(slow+1, fast+1);
                if (subString.length() == 0 || subString.length() > currSubString.length()) {
                    subString = currSubString;
                }
                
                slow++;
                char currChar = s.charAt(slow);
                if (currMap.get(currChar) == 1) {
                    currMap.remove(currChar);
                } else {
                    currMap.put(currChar, currMap.get(currChar) - 1);
                }
                
                if (currMap.getOrDefault(currChar, 0) < map.getOrDefault(currChar, 0)) {
                    currCount--;
                }
                flag2 = true;
            }
            
            if (flag1 == false && flag2 == false) {
                break;
            }
        }
        
        return subString;
    }
}

/*
Time complexity: O(n)
Space Compelxity: O(n)
*/
