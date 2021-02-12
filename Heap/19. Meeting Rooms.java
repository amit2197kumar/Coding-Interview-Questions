/*
Company Tags:  Amazon Apple Flipkart Microsoft
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/meeting-rooms/
LeetCode: https://www.lintcode.com/problem/meeting-rooms-ii/description
*/

/*
The idea is to consider all events in sorted order.
Once the events are in sorted order, trace the number of meetings at any time keeping track of meetings that have started, but not ended.

Use min heap to store the meeting rooms end time. If new meeting start time is greater or equal than least element, update it.
If not, open a new meeting room. Report the min heap size at the end.
Time Complexity : O(NlogN).
*/

/*
Check Out:
1. http://blog.gainlo.co/index.php/2016/07/12/meeting-room-scheduling-problem/
2. https://www.learnbay.io/meeting-rooms-ii/
3. https://www.youtube.com/watch?v=PWgFnSygweI
*/

public class Solution {

    class Pair implements Comparable<Pair> {
        int start, end;
        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair pair) {
            if (this.start > pair.start)
                return 1;
            else if (this.start == pair.start)
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

        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair one, Pair two) {
                if (two.end < one.end)
                    return 1;
                else if (two.end == one.end)
                    return 0;
                else
                    return -1;
            }
        });

        minHeap.add(intervals.get(0));

        for (int i=1; i<intervals.size(); i++) {

            Pair currentMeeting = intervals.get(i);

            if (currentMeeting.start >= minHeap.peek().end)
                minHeap.poll();

            minHeap.add(currentMeeting);

        }

        return minHeap.size();
    }
}

/*
Time Complexity : O(NlogN).
*/
