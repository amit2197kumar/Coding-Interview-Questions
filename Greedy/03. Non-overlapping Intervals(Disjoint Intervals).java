/*
Company Tags:  Google
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/disjoint-intervals/
LeetCode: https://leetcode.com/problems/non-overlapping-intervals/
*/

/*
We will solve this using greedy approach.

-> Sort the intervals, with respect to their end points.
-> Now, traverse through all the intervals, if we get two overlapping intervals, then greedily choose the interval with lower end point since,
   choosing it will ensure that intervals further can be accommodated without any overlap.
-> Apply the same procedure for all the intervals and return the count of intervals which satisfy the above criteria.
*/

public class Solution {

    class Pair implements Comparable<Pair> {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair pair) {
            if (this.second > pair.second)
                return 1;
            else if (this.second == pair.second)
                return 0;
            else
                return -1;
        }
    }

    public int solve(int[][] arr) {
        List<Pair> intervals = new ArrayList<>();

        for (int i=0; i<arr.length; i++) {
            Pair pair = new Pair(arr[i][0], arr[i][1]);
            intervals.add(pair);
        }

        Collections.sort(intervals);

        int count = 1;
        int end = intervals.get(0).second;
        for (int i=1; i<intervals.size(); i++) {
            int currStart = intervals.get(i).first;
            int currEnd = intervals.get(i).second;

            if (end < currStart) {
                count++;
                end = currEnd;
            }
        }

        return count;
    }
}

/*
Time Complexity: O(N log(N)) [Sorting is involved]
Artical:
1. https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/
2. https://www.geeksforgeeks.org/maximal-disjoint-intervals/
*/