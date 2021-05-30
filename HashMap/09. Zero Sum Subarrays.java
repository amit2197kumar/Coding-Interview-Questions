/*
Company Tags: Amazon Microsoft OYO Rooms
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
*/

class Solution{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) {
        //Your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        long count = 0l;
        map.put(sum, 1);
        
        for (int i=0; i<n; i++) {
            sum += arr[i];
            
            if (map.containsKey(sum)) {
                count += Long.valueOf(map.get(sum));
                map.put(sum, map.get(sum)+1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }
}

/*
Time complexity O(n). As single traversal of the array is required.
Space Compelxity O(n). Since, the hashmap requires linear space.
*/
