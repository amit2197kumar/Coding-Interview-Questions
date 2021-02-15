/*
Company Tags:  Accolite Samsung Amazon
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
*/

//Parent Problem: Find the next greater element in the right in an array

class solve{
    public static int[] calculateSpan(int price[], int n)
    {
        int[] lowStock = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            lowStock[i] = 1;
        }

        for (int i=0; i<n; i++) {
            if (stack.isEmpty()) {
                lowStock[i] += 0;
            } else {
                while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                    lowStock[i] += lowStock[stack.pop()];
                }
            }

            stack.add(i);
        }

        return lowStock;
    }
}

/*
Time Complexity: O(n). It seems more than O(n) at first look. If we take a closer look, we can observe that every element of
the array is added and removed from the stack at most once. So there are total 2n operations at most. Assuming that a stack
operation takes O(1) time, we can say that the time complexity is O(n).

Auxiliary Space: O(n) in worst case when all elements are sorted in decreasing order.
*/
