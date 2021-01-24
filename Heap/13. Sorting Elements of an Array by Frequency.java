/*
Company Tags: Oracle Zoho Zycus
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0
*/

/****************************************** Using PriorityQueue (Geeksforgeeks) ********************************************/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();
        while(tc-- > 0) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int i=0; i<size; i++)
                arr[i] = scan.nextInt();

            HashMap<Integer, Integer> map = new HashMap<>();
            for (Integer value : arr) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            PriorityQueue<Integer> minheap = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    //Check why only below 1 line code won't work!!!
                    //return map.get(b) - map.get(a);

                    if (map.get(a) != map.get(b))
                        return map.get(b) - map.get(a);
                    else
                        return a-b;
                }
            });
            minheap.addAll(map.keySet());

            while (!minheap.isEmpty()) {
                int curr = minheap.poll();
                int num = map.get(curr);
                for (int i=0; i<num; i++)
                    System.out.print(curr + " ");
            }
            System.out.println();
        }
    }
}