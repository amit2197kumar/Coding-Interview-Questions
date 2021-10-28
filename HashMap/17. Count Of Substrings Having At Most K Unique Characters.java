/*
Company Tags:  
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/count-of-substrings-having-at-most-k-unique-characters-official/ojquestion
*/

import java.util.*;

public class Main {

    public static int solution(String str, int k) {
        int count = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        while (true) {

            while (i < str.length() - 1) {
                i++;
                char curr = str.charAt(i);
                map.put(curr, map.getOrDefault(curr, 0) + 1);


                if (map.size() > k) {
                    break;
                } else {
                    count += i-j;
                }
            }

            if (i == str.length()-1 && map.size() <= k) {
                break;
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
                    count += i-j;
                    break;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        System.out.println(solution(str,k));
    }

}
