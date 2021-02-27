/*
Company Tags:   OYO Rooms
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        while (testCase-- > 0) {
            int no = scan.nextInt();
            int[] arr = new int[no];

            for (int i=0; i<no; i++) {
                arr[i] = scan.nextInt();
            }

            int k = scan.nextInt();
            List<Integer> list = new ArrayList<>();

            int i, j;
            i=0; j=0;

            Queue<Integer> queue = new LinkedList<>();

            for (j=0; j<no; j++) {
                if (arr[j] < 0) {
                    queue.add(arr[j]);
                }

                int windowSize = j - i + 1;
                if (windowSize == k) {
                    if (queue.isEmpty()) {
                        list.add(0);
                    } else {
                        list.add(queue.peek());
                    }

                    if (!queue.isEmpty() && queue.peek() == arr[i]) {
                        queue.remove();
                    }

                    i++;
                }
            }

            for (int q=0; q<list.size(); q++) {
                System.out.print(list.get(q) + " ");
            }
            System.out.println();
        }
    }
}

/*
Time Complexity: O(n)
Auxiliary Space: O(k)
*/