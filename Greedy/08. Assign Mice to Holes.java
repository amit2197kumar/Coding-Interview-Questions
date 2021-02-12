/*
Company Tags:  Amazon
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/assign-mice-to-holes/
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/assign-mice-holes3053/1
*/

/*
This problem can be solved using greedy strategy. We can put every mouse to its nearest hole to minimize the time.
This can be done by sorting the positions of mice and holes. This allows us to put the ith mice to the corresponding hole in the holes list.
We can then find the maximum difference between the mice and corresponding hole position.
*/

public class Solution {
    public int mice(int[] mice, int[] hole) {
        Arrays.sort(mice);
        Arrays.sort(hole);

        int max = 0;
        for (int i=0; i<mice.length; i++) {
            int diff = Math.abs(mice[i] - hole[i]);
            max = (max > diff ? max : diff) ;
        }

        return max;
    }
}

/*
Complexity Analysis
Time Complexity: O(n)
Space Complexity: O(1)
 */