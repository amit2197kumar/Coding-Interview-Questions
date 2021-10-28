/*
Company Tags:  
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/equal-0-1-and-23208/1
*/

class Solution 
{ 
    long getSubstringWithEqual012(String str) { 
        String[] arr = str.split("");
        
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        
        int diff10 = 0;
        int diff21 = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        String key = "0#0";
        map.put(key, 1);
        long count = 0;
        
        for (int i=0; i<arr.length; i++) {
            
            if (arr[i].equals("0")){
                count0++;
            } else if (arr[i].equals("1")) {
                count1++;
            } else {
                count2++;
            }
            
            diff10 = count1 - count0;
            diff21 = count2 - count1;
            
            key = diff10 + "#" + diff21;
            if (map.containsKey(key)) {
                count += map.get(key);
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        return count;
    }
} 
