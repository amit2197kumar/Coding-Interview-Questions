/*
Company Tags: Amazon Intuit Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
LeetCode: https://leetcode.com/problems/find-all-anagrams-in-a-string/
*/

/******************************************* APPROACH 01 **************************************************************/
/***************************************** Geeksforgeeks **************************************************************/

class Solution {

    int search(String pat, String txt) {
        int ASCII_Sum = 0;
        for (int i=0; i<pat.length(); i++) {
            ASCII_Sum += pat.charAt(i);
        }

        int currSum = 0;
        int i=0, j=0;
        int anagrams = 0;

        for (j=0; j<txt.length(); j++) {
            currSum += txt.charAt(j);

            int windowSize = j-i+1;
            if (windowSize == pat.length()) {
                if (currSum == ASCII_Sum && isSame(txt.substring(i,j+1), pat)) {
                    anagrams++;
                }

                currSum -= txt.charAt(i);
                i++;
            }
        }

        return anagrams;
    }

    boolean isSame(String first, String second) {
        first = sortString(first);
        second = sortString(second);

        for (int i=0; i<first.length(); i++) {
            if (first.charAt(i) != second.charAt(i))
                return false;
        }
        return true;
    }

    String sortString(String original) {
        char[] chars = original.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

/******************************************* APPROACH 02 **************************************************************/
/********************************************** LeetCode **************************************************************/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<Integer>();

        int k = p.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0; i<k; i++) {
            char c = p.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int i=0, j=0;
        int count = map.size();

        while (j < s.length()) {
            char curr = s.charAt(j);

            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);

                if (map.get(curr) == 0) {
                    count--;
                }
            }

            int windowSize = j-i+1;

            if (windowSize == k) {
                if (count == 0) {
                    list.add(i);
                }

                // Reversing the above task again.
                // VERY IMPORTANT TO UNDERSTAND
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

                    if (map.get(s.charAt(i)) == 1) {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return list;
    }
}

/*
Time Complexity: O(n)
Auxiliary Space: O(k)
*/