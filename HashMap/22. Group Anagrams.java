/*
Company Tags:  
Practice Portal:
LeetCode: https://leetcode.com/problems/group-anagrams/
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listOfLists = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> bigMap = new HashMap<>();
        
        for (String value : strs) {
            HashMap<Character, Integer> smallMap = new HashMap<>();
            for (int i=0; i<value.length(); i++) {
                char curr = value.charAt(i);
                smallMap.put(curr, smallMap.getOrDefault(curr, 0) + 1);
            }
            
            if (bigMap.containsKey(smallMap)) {
                List<String> list = bigMap.get(smallMap);
                list.add(value);
                bigMap.put(smallMap, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(value);
                bigMap.put(smallMap, list);
            }
        }
        
        for (List<String> list : bigMap.values()) {
            listOfLists.add(list);
        }
        return listOfLists;
    }
}
