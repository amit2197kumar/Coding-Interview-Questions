/*
Company Tags:  
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/common-elements5420/1
*/

class Solution{
    public static ArrayList<Integer> common_element(ArrayList<Integer> v1, ArrayList<Integer> v2) {
        
        ArrayList<Integer> common = new ArrayList<>();
        
        if (v1.size()  == 0 || v2.size() == 0)
            return common;
        
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (Integer value : v1) {
            if (hashmap.containsKey(value)) {
                hashmap.put(value, hashmap.get(value) + 1);
            } else {
                hashmap.put(value, 1);
            }
        }
        
        for (Integer value : v2) {
            if (hashmap.containsKey(value)) {
                common.add(value);
                hashmap.put(value, hashmap.get(value)-1);
                
                if (hashmap.get(value) == 0) {
                    hashmap.remove(value);
                }
            }
        }
        
        Collections.sort(common);
        return common;
    }
}

/*
Time Complexity: O(n) 
Space Complexity: O(n)
*/
