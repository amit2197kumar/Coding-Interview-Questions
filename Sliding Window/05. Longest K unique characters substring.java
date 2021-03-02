/*
Company Tags:  Amazon Google SAP Labs
Practice Portal:
Geeksforgeeks : https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring/0
*/

/*
While implemention i had first used Java Set: https://www.geeksforgeeks.org/set-in-java/
But that was imcorrect, think WHY !!!!!!!
Code with Set: https://ide.geeksforgeeks.org/bJaNhsSsm5
*/

// This problem belongs to VARIBALE size sliding window varient

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        while (testCase-- > 0) {
            String str = scan.next();
            int k = scan.nextInt();

            int maxLen = -1;
            int i=0, j=0;

            HashMap<Character, Integer> map = new HashMap<>();

            for (j=0; j<str.length(); j++) {

                if (map.containsKey(str.charAt(j))) {
                    map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
                } else {
                    map.put(str.charAt(j), 1);
                }

                if (map.size() == k) {
                    int windowSize = j - i + 1;
                    maxLen = Math.max(maxLen ,windowSize);
                }

                if (map.size() > k) {
                    while (map.size() != k) {
                        char ch = str.charAt(i);
                        if (map.get(ch) == 1) {
                            map.remove(ch);
                        } else {
                            map.put(ch, map.get(ch) - 1);
                        }
                        i++;
                    }
                }
            }

            System.out.println(maxLen);
        }
    }
}

/*
Time Complexity:  O(n)
Space Complexity: O(n) worstcase (think why?!!)
*/

//Try this now : https://leetcode.com/problems/subarrays-with-k-different-integers/
