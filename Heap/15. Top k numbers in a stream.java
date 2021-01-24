/*
Company Tags: Accolite Amazon
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/top-k-numbers3425/1
*/

/****************************************** Using PriorityQueue (Geeksforgeeks) ***************************************/

class Solution
{
    static ArrayList<Integer> kTop(int[] arr, int n, int k) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i=0; i<n; i++) {
            int count = k;
            HashMap<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> minheap = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    if (map.get(a) != map.get(b))
                        return map.get(b) - map.get(a);
                    else
                        return a-b;
                }
            });

            for (int j=0; j<=i; j++) {
                map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            }

            minheap.addAll(map.keySet());

            while (minheap.size() > 0 && count-- > 0)
                list.add(minheap.poll());
        }

        return list;
    }
}