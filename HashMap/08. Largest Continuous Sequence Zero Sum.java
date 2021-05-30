/*
Company Tags: Amazon MakeMyTrip Microsoft
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
InterviewBit: https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/
*/

public class Solution {
    public int[] lszero(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int index = -1;
        int maxLen = 0;
        
        int start = 0;
        int end = 0;
        
        map.put(sum, index);
        
        for (int i=0; i<n; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                int pastIndex = map.get(sum);
                int currLen = (i - pastIndex);
                if (maxLen < currLen) {
                    maxLen = currLen;
                    start = pastIndex+1;
                    end = i;
                }
            } else {
                map.put(sum, i);
            }
        }
        
        int[] zero = new int[maxLen];
        
        if (maxLen == 0)
            return zero;
        
        
        int j=0;
        for (int i=start; i<=end; i++) {
            zero[j++] = arr[i];
        }
        return zero;
    }
}

/*
Time complexity O(n). As single traversal of the array is required.
Space Compelxity O(n). Since, the hashmap requires linear space.
*/
