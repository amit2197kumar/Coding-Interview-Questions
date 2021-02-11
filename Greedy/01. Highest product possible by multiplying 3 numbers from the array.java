/*
Company Tags:  Amazon
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/highest-product/
*/

/*
Choosing 3 maximum elements in the array and 2 negative elements with the highest absolute value should be enough.
*/

public class Solution {
    public int maxp3(int[] arr) {
        int len = arr.length;
        if (len < 3) return 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i=0; i<len; i++) {
            pQueue.add(arr[i]);
        }

        int m1, m2, m3, l1, l2;
        m1 = m2 = m3 = l1 = l2 = Integer.MIN_VALUE;
        m1 = pQueue.poll();
        m2 = pQueue.poll();
        m3 = pQueue.poll();

        while (pQueue.size() > 2)
            pQueue.poll();

        if (pQueue.size() == 2) {
            l1 = pQueue.poll();
            l2 = pQueue.poll();

            return Math.max(m1*m2*m3, l1*l2*m1);
        }
        return m1*m2*m3;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(n)
*/

/**********************************************************************************************************************/
/**********************************************************************************************************************/

public class Solution {
    public int maxp3(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        Arrays.sort(arr);

        int prod_1 = arr[0] * arr[1] * arr[n-1];
        int prod_2 = arr[n-1] * arr[n-2] * arr[n-3];

        return Math.max(prod_1,prod_2);
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/

