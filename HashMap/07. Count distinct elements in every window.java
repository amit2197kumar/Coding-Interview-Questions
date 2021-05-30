/*
Company Tags: Amazon
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
InterviewBit: https://www.interviewbit.com/problems/distinct-numbers-in-window/
*/

public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> array, int k) {
        int n = array.size();
        ArrayList<Integer> countDiff = new ArrayList<Integer>();
        HashMap<Integer, Integer> window = new HashMap<Integer, Integer>();
        
        for (int i=0; i<k; i++) {
            int count = window.getOrDefault(array.get(i), 0);
            window.put(array.get(i), ++count);
        }
        
        countDiff.add(window.size());
        int tail = 0;
        
        for (int i=k; i<n; i++) {
            /******** Remove the outer window element ***************/
            window.put(array.get(tail), window.get(array.get(tail))-1);
            if (window.get(array.get(tail)) == 0) {
                window.remove(array.get(tail));
            }
            tail++;
            /********************************************************/
            
            
            int count = window.getOrDefault(array.get(i), 0);
            window.put(array.get(i), ++count);
            
            countDiff.add(window.size());
        }
        
        return countDiff;
    }
}

/*
Time complexity O(n). As single traversal of the array is required.
Space Compelxity O(n). Since, the hashmap requires linear space.
*/
