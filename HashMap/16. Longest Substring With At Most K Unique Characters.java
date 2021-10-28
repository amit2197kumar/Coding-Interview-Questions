/*
Company Tags:  
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/longest-substring-with-at-most-k-unique-characters-official/ojquestion
*/

import java.util.*;

public class Main {

    public static int solution(String str, int k) {
        int maxLen = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;

            while (i < str.length() - 1) {
                i++;
                char curr = str.charAt(i);
                map.put(curr, map.getOrDefault(curr, 0) + 1);


                if (map.size() > k) {
                    break;
                } else {
                    int len = i - j ;
                    maxLen = Math.max(len, maxLen);
                }

                flag1 = true;
            }


            while (j < i) {
                j++;
                char curr = str.charAt(j);

                if (map.get(curr) == 1) {
                    map.remove(curr);
                } else {
                    map.put(curr, map.get(curr) - 1);
                }

                if (map.size() == k) {
                    break;
                }

                flag2 = true;
            }

            if (flag1 == false && flag2 == false) {
                break;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str,k));
    }

}
