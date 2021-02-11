/*
Company Tags:  D. E. Shaw & Co
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/largest-permutation/
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/largest-permutation/0
*/

public class Solution {
    public int[] solve(int[] arr, int B) {
        int count = 0;

        // If number of swap is more then array lengh, extra swaps are of NO use
        if (arr.length < B)
            B = arr.length;

        for (int i=0; i<B; i++) {
            int min = count;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] > arr[min])
                    min = j;
            }

            if (count != min) {
                swap(arr, count, min);
            } else {
                //If we havn't swapped itself, thst chance shouldn't be counted
                B++;
            }

            count++;
        }

        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/*
Time Complexity: O(n^2)
*/

/**********************************************************************************************************************/
/**********************************************************************************************************************/

/*
We can use a combination of Heap and HashMap. to achieve the following things.
Heap: It will help us to give either max or min in constant time complexity
HashMap: It will help us to store/fetch items (key, value) in logarithmic time complexity.

The approach is like that:
1. Store the item and its index in hashMap.
2. Also store all the items of array which are in the range[1, N-1] to the heap(priority_queue)
*/

public class Solution {
    public int[] solve(int[] arr, int B) {

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<arr.length; i++) {
            map.put(arr[i], i);
            pQueue.add(arr[i]);
        }

        for (int i=0; i<arr.length; i++) {

            if (pQueue.peek() != arr[i]) {

                int value = pQueue.poll();
                int index = map.get(value);

                map.remove(arr[i]);
                map.put(arr[i], index);

                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;

                B--;
            } else {
                pQueue.poll();
            }

            if (B == 0)
                break;
        }

        return arr;
    }
}

/*
Time Complexity: O(n Logn)
*/

