/*
Company Tags:  
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/find-anagram-mappings-official/ojquestion
*/

import java.util.*;
public class Main {
    class Pair {
        int index;
        ArrayList<Integer> list;

        Pair(int index) {
            this.index = index;
            list = new ArrayList<>();
        }
    }

    public int[] anagramMappings(int[] arr1, int[] arr2) {
        int size = arr1.length;
        int[] arr3 = new int[size];
        HashMap<Integer, Pair> map = new HashMap<>();

        for (int i=0; i<size; i++) {
            if (map.containsKey(arr2[i])) {
                Pair pair = map.get(arr2[i]);
                pair.list.add(i);
                map.put(arr2[i], pair);
            } else {
                Pair pair = new Pair(0);
                pair.list.add(i);
                map.put(arr2[i], pair);
            }
        }

        int i=0;
        for (Integer value : arr1) {
            Pair pair = map.get(value);
            arr3[i++] = pair.list.get(pair.index++);
        }

        return arr3;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        Main main = new Main();

        for (int i = 0; i < a.length; i++) {
            a[i] = s.nextInt();
        }
        for (int j = 0; j < b.length; j++) {
            b[j] = s.nextInt();
        }
        int[] res = main.anagramMappings(a, b);
        for (int j = 0; j < res.length; j++) {
            System.out.print(res[j] + " ");
        }
    }

}
