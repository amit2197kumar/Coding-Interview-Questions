# Greedy Algorithms

## What are greedy algorithm?

A greedy algorithm, as the name suggests, always makes the choice that seems to be the best at that moment. This means that it makes a locally-optimal choice in the hope that this choice will lead to a globally-optimal solution.

The Greedy algorithm has only one shot to compute the optimal solution so that it never goes back and reverses the decision.

**Where to use Greedy algorithms?**

A problem must comprise these two components for a greedy algorithm to work:

1. It has **optimal substructures**. The optimal solution for the problem contains optimal solutions to the sub-problems.
2. It has a **greedy property** (hard to prove its correctness!). If you make a choice that seems the best at the moment and solve the remaining sub-problems later, you still reach an optimal solution. You will never have to reconsider your earlier choices.

## Theory:

1. [Basics of Greedy Algorithms](https://www.hackerearth.com/practice/algorithms/greedy/basics-of-greedy-algorithms/tutorial/)
2. [Greedy Algorithm - Interviewbit](https://www.interviewbit.com/tutorial/greedy-algorithm-examples/)
3. [Greedy Method - Introduction](https://youtu.be/ARvQcqJ_-NY)

## Coding Questions:

1. [Highest product possible by multiplying 3 numbers from the array](https://www.interviewbit.com/problems/highest-product/) **
2. [Switch ON all bulbs](https://www.interviewbit.com/problems/interview-questions/) **
3. [Non-overlapping Intervals(Disjoint Intervals)](https://www.interviewbit.com/problems/disjoint-intervals/) ***
4. [Largest permutation after at most k swaps](https://www.interviewbit.com/problems/largest-permutation/) ***
5. [Meeting Rooms](https://www.interviewbit.com/problems/meeting-rooms/) ****
6. [Distribute Candy](https://www.interviewbit.com/problems/distribute-candy/) **
7. [Gas Station](https://www.interviewbit.com/problems/gas-station/) ****
8. [Assign Mice to Holes](https://www.interviewbit.com/problems/assign-mice-to-holes/) *
9. [Majority Element](https://www.interviewbit.com/problems/majority-element/)
10. [Seats(Minimum jumps required to make a group of persons sit together)](https://www.interviewbit.com/problems/seats/) ****
11. [Activity Selection](https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1) **
12. [N meetings in one room](https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1) **
13. [Fractional Knapsack](https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1) ***

## Important code snippet highly used:

### Comparable:
```java
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
```

### Comparator:
```java
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
```

Original Post at [Notion](https://www.notion.so/Greedy-250f9c535f9949e0b4ebc0706c5004a1)
