/*
Company Tags: Amazon
Practice Portal:
Geeksforgeeks : https://practice.geeksforgeeks.org/problems/rearrange-characters/0
LeetCode: https://leetcode.com/problems/reorganize-string/
(Both Qs above are diffrent subtype)
*/

/*************************************** Using PriorityQueue (geeksforgeeks) ******************************************/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) {
        Scanner scan = new Scanner (System.in);
        int testcase = scan.nextInt();
        while(testcase-- > 0) {
            String str = scan.next();

            HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
            for (int i=0; i<str.length(); i++) {
                charCount.put(str.charAt(i), charCount.getOrDefault(str.charAt(i), 0) + 1);
            }

            PriorityQueue<Character> maxheap = new PriorityQueue<>(new Comparator<Character>() {
                public int compare(Character a, Character b) {
                    return charCount.get(b) - charCount.get(a);
                }
            });

            maxheap.addAll(charCount.keySet());

            if (charCount.get(maxheap.peek()) > str.length()/2)
                System.out.println(0);
            else
                System.out.println(1);
        }
    }
}

/****************************************** Using PriorityQueue (LeetCode) ********************************************/

class Solution {
    public String reorganizeString(String str) {
        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
        for (int i=0; i<str.length(); i++) {
            charCount.put(str.charAt(i), charCount.getOrDefault(str.charAt(i), 0) + 1);
        }

        PriorityQueue<Character> maxheap = new PriorityQueue<>(new Comparator<Character>() {
            public int compare(Character a, Character b) {
                return charCount.get(b) - charCount.get(a);
            }
        });

        maxheap.addAll(charCount.keySet());

        StringBuilder result = new StringBuilder();
        while (maxheap.size() > 1) {
            char currentMax = maxheap.poll();
            char nextMax = maxheap.poll();

            result.append(currentMax);
            result.append(nextMax);

            charCount.put(currentMax, charCount.get(currentMax) - 1);
            charCount.put(nextMax, charCount.get(nextMax) - 1);

            if (charCount.get(currentMax) > 0)
                maxheap.add(currentMax);
            if (charCount.get(nextMax) > 0)
                maxheap.add(nextMax);
        }

        if (!maxheap.isEmpty()) {
            char lastChar = maxheap.remove();
            if (charCount.get(lastChar) > 1) {
                return "";
            }
            result.append(lastChar);
        }

        return result.toString();
    }
}