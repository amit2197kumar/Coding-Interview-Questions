/*
Company Tags: D-E-Shaw
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/count-number-of-substrings4528/1
*/

class Sol
{
    long substrCount (String str, int k) {
        int count = 0;
        
        if (k == 1) {
            return substrCountForKValueOne(str);
        }
        
        HashMap<Character, Integer> smallMap = new HashMap<>();
        HashMap<Character, Integer> bigMap = new HashMap<>();
        
        int smallFast = -1;
        int bigFast = -1;
        int slow = -1;
        
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            
            while (bigFast < str.length() - 1) {
                bigFast++;
                char currChar = str.charAt(bigFast);
                bigMap.put(currChar, bigMap.getOrDefault(currChar, 0) + 1);
                
                if (bigMap.size() == k+1) {
                    removeFromMap(bigMap, currChar);
                    bigFast--;
                    break;
                }
                flag1 = true;
            }
            
            while (smallFast < bigFast) {
                smallFast++;
                char currChar = str.charAt(smallFast);
                smallMap.put(currChar, smallMap.getOrDefault(currChar, 0) + 1);
                
                if (smallMap.size() == k) {
                    removeFromMap(smallMap, currChar);
                    smallFast--;
                    break;
                }
                flag2 = true;
            }
            
            while (slow < smallFast) {
                if (bigMap.size() == k && smallMap.size() == k-1) {
                    count += bigFast - smallFast; 
                }
                
                slow++;
                char currChar = str.charAt(slow);
                removeFromMap(bigMap, currChar);
                removeFromMap(smallMap, currChar);
                
                if (smallMap.size() < k-1 || bigMap.size() < k) {
                    break;
                }
                flag3 = true;
            }
            
            if (flag1 == false && flag2 == false && flag3 == false) {
                break;
            }
        }
        
        return count;
    }
    
    void removeFromMap(HashMap<Character, Integer> map, char ch) {
        if (map.get(ch) == 1) {
            map.remove(ch);
        } else {
            map.put(ch, map.get(ch) - 1);
        }
    }
    
    long substrCountForKValueOne(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        
        int fast = -1;
        int slow = -1;
        
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            
            while (fast < str.length() - 1) {
                fast++;
                char currChar = str.charAt(fast);
                map.put(currChar, map.getOrDefault(currChar, 0) + 1);
                
                if (map.size() == 2) {
                    removeFromMap(map, currChar);
                    fast--;
                    break;
                }
                flag1 = true;
            }
            
            while (slow < fast) {
                if (map.size() == 1) {
                    count += fast - slow;
                }
                
                slow++;
                char currChar = str.charAt(fast);
                removeFromMap(map, currChar);
                
                if (map.size() == 0) {
                    break;
                }
                flag2 = true;
            }
            
            if (flag1 == false && flag2 == false) {
                break;
            }
        }
        
        return count;
    }
}

/*
Time Complexity: O(n) 
Space Complexity: O(1)
*/

 
