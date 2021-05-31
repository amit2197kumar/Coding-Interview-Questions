/*
Company Tags:  
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/equivalent-sub-arrays3731/1
*/

class Solution
{ 
    // Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) { 
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer value : arr) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        
        int size = map.size();
        
        int fast = -1;
        int slow = -1;
        map.clear();
        
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;
            
            while (fast < n-1) {
                fast++;
                map.put(arr[fast], map.getOrDefault(arr[fast], 0) + 1);
                if (map.size() == size) {
                    count += n - fast;
                    break;
                }
                flag1 = true;
            }
            
            while (map.size() == size) {
                slow++;
                if (map.get(arr[slow]) == 1) {
                    map.remove(arr[slow]);
                } else {
                    map.put(arr[slow], map.get(arr[slow]) - 1);
                }
                
                if (map.size() == size) {
                    count += n - fast;
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
