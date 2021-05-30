/*
Company Tags:  
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/maximum-occuring-character-1587115620/1
*/

class Solution
{
    //Function to find the maximum occurring character in a string.
    public static char getMaxOccuringChar(String line) {
        int len = line.length();
        HashMap<Character, Integer> hashmap = new HashMap<>();
        
        Character maxC = 'a';
        Integer maxCount = Integer.MIN_VALUE;
        
        for (int i=0; i<len; i++) {
            if (hashmap.containsKey(line.charAt(i))) {
                hashmap.put(line.charAt(i), hashmap.get(line.charAt(i)) + 1);
            } else {
                hashmap.put(line.charAt(i), 1);
            }
        }
        
        for (Character ch : hashmap.keySet()) {
            if (hashmap.get(ch) > maxCount) {
                maxCount = hashmap.get(ch);
                maxC = ch;
            } else if (hashmap.get(ch) == maxCount) {
                if (ch < maxC) {
                    maxC = ch;
                }
            }
        }
        
        return maxC;
    }
}

/*
Time Complexity: O(n) 
Space Complexity: O(1) — Because we are using fixed space (Hash array) irrespective of input string size.
*/
