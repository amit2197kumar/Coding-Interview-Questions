/*
Company Tags:  
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-subarray-with-equal-number-of-0s-1s-and-2s-official/ojquestion
*/

import java.util.*;

public class Main {

    public static int solution(int[] arr) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        int diff10 = 0;
        int diff21 = 0;

        HashMap<String, Integer> map = new HashMap<>();
        String key = "0#0";
        map.put(key, -1);
        int maxLen = 0;

        for (int i=0; i<arr.length; i++) {
            if (arr[i] == 0) {
                count0++;
            } else if (arr[i] == 1) {
                count1++;
            } else {
                count2++;
            }

            diff10 = count1 - count0;
            diff21 = count2 - count1;

            key = diff10 + "#" + diff21;
            if (map.containsKey(key)) {
                int len = i - map.get(key);
                maxLen = Math.max(maxLen, len);
            } else {
                map.put(key, i);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}
