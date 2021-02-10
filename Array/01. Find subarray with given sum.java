/*
Company Tags: Amazon Facebook Google Visa
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
*/

/*
There is an idea if all the elements of the array are positive. If a subarray has sum greater than the given sum then there is no
possibility that adding elements to the current subarray the sum will be x (given sum). Idea is to use a similar approach to a sliding window.
Start with an empty subarray, add elements to the subarray until the sum is less than x. If the sum is greater than x, remove elements from the start of the current subarray.
*/

class Subarray{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int S) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        int tail, head, sum;
        tail = head = sum = 0;

        for (head=0; head<n; head++) {
            sum = sum + arr[head];

            while (sum > S) {
                sum = sum - arr[tail++];
            }

            if (sum == S) {
                list.add(tail + 1);
                list.add(head + 1);
                return list;
            }

        }

        list.add(-1);
        return list;
    }
}

/*
Time Complexity : O(n).
Only one traversal of the array is required. So the time complexity is O(n).
Space Complexity: O(1).
*/