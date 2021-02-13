/*
Company Tags:  Amazon Apple Flipkart Microsoft
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
*/

/*
Good To go the following: https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/

The greedy choice is to always pick the next activity whose finish time is least among the remaining activities and the
start time is more than or equal to the finish time of previously selected activity. We can sort the activities according to their
finishing time so that we always consider the next activity as minimum finishing time activity.

1) Sort the activities according to their finishing time
2) Select the first activity from the sorted array and print it.
3) Do following for remaining activities in the sorted array.
…….a) If the start time of this activity is greater than or equal to the finish time of previously selected activity then select this activity and print it.
*/

class Meeting {
    static class Pair {
        int sTime, eTime;
        Pair(int sTime, int eTime) {
            this.sTime = sTime;
            this.eTime = eTime;
        }
    }
    static Pair pair;
    public static int maxMeetings(int start[], int end[], int n) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair one, Pair two) {
                if (one.eTime > two.eTime)
                    return 1;
                else if (one.eTime == two.eTime)
                    return 0;
                else
                    return -1;
            }
        });

        for (int i=0; i<n; i++) {
            pair = new Pair(start[i], end[i]);
            minHeap.add(pair);
        }

        int count = 1;
        Pair activity = minHeap.poll();
        while (minHeap.size() > 0) {
            Pair curr = minHeap.poll();

            if (curr.sTime > activity.eTime) {
                count++;
                activity = curr;
            }

        }

        return count;
    }
}

/*
Time Complexity : It takes O(n log n) time if input activities may not be sorted.
It takes O(n) time when it is given that input activities are always sorted.
*/