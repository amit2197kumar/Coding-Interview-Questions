/*
Company Tags:   Accolite Amazon Cisco Citrix MAQ Software OYO Rooms Samsung Snapdeal Walmart Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        while(testCase-- > 0) {
            String str = scan.next();
            ArrayList<String> list = new ArrayList<>();
            printPermutations(str, 0, str.length(), list);
            Collections.sort(list);
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void printPermutations(String str, int start, int end, ArrayList<String> list) {
        if (start > end)
            return;

        if (start == end)
            list.add(str);

        for (int i=start; i<end; i++) {
            str = swap(str, start, i);
            printPermutations(str, start+1, end, list);
            str = swap(str, start, i);
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArr = str.toCharArray();

        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;

        return String.valueOf(charArr);
    }
}

/*
Algorithm Paradigm: Backtracking
Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation.

Find out how TC is O(n*n!) from here: https://youtu.be/AfxHGNRtFac?t=553
 */

/*
BUT BUT BUT !!!!!!!!!!!!!!!
Above solution has an issue.
For Duplicate alphabets it prints duplicate output
For Input:
1
AAB
your output is:
AAB AAB ABA ABA BAA BAA
*/

// We used Set in place of ArrayList to remove the duplicates.
//Read about Set here : https://www.geeksforgeeks.org/set-in-java/

import java.util.*;
        import java.lang.*;
        import java.io.*;
class GFG
{
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        while(testCase-- > 0) {
            String str = scan.next();
            Set<String> list = new HashSet<String>();
            printPermutations(str, 0, str.length(), list);
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void printPermutations(String str, int start, int end, Set<String> list) {
        if (start > end)
            return;

        if (start == end)
            list.add(str);

        for (int i=start; i<end; i++) {
            str = swap(str, start, i);
            printPermutations(str, start+1, end, list);
            str = swap(str, start, i);
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArr = str.toCharArray();

        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;

        return String.valueOf(charArr);
    }
}

/*
BUT BUT BUT
the issue is out won't come in lexicographically order, as Collections.sort(); won't work on set
*/

// FINAL CORRECT CODE:

import java.util.*;
        import java.lang.*;
        import java.io.*;
class GFG
{
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        while(testCase-- > 0) {
            String str = scan.next();

            Set<String> set = new HashSet<String>();
            printPermutations(str, 0, str.length(), set);

            List<String> list = new ArrayList<String>(set);
            Collections.sort(list);

            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public static void printPermutations(String str, int start, int end, Set<String> set) {
        if (start > end)
            return;

        if (start == end)
            set.add(str);

        for (int i=start; i<end; i++) {
            str = swap(str, start, i);
            printPermutations(str, start+1, end, set);
            str = swap(str, start, i);
        }
    }

    public static String swap(String str, int i, int j) {
        char[] charArr = str.toCharArray();

        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;

        return String.valueOf(charArr);
    }
}

/*
Algorithm Paradigm: Backtracking
Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a a permutation.

Find out how TC is O(n*n!) from here: https://youtu.be/AfxHGNRtFac?t=553
 */