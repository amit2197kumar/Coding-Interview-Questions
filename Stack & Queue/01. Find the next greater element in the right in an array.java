/*
Company Tags:   Flipkart Amazon
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
*/

/*
ALgo:
We have an as array and a stack.
We start traversing from right to left of the array.
While traversing:
1. If stack is empty() add -1 to ans[] and push element to stack
2. If arr index element > stack top element : POP
3. If arr index element > stack top element : add stack peek to ans[]
4. At end we Push all element to the stack


Checkout:
1. https://youtu.be/NXOOYYwpbg4?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
2. https://afteracademy.com/blog/find-the-next-greater-element-for-every-element-in-an-array
*/

//THIS IS PARENT PROBLEM

class solve{
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] nextLarger = new long[n];
        Stack<Long> storeLarge = new Stack<>();

        for (int i=n-1; i>=0; i--) {
            if (storeLarge.isEmpty()) {
                nextLarger[i] = -1;
            } else {
                while (!storeLarge.isEmpty() && storeLarge.peek() < arr[i])
                    storeLarge.pop();

                if (storeLarge.isEmpty()) {
                    nextLarger[i] = -1;
                } else {
                    nextLarger[i] = storeLarge.peek();
                }
            }

            storeLarge.push(arr[i]);
        }

        return nextLarger;
    }
}

/*
Complexity Analysis:
Note that each element is visited at most twice, first while pushing them onto the stack and second while popping them from the stack. (Think!)

Time Complexity: Traversal of the array and Stack Manipulation = O(2*n) (Why?) = O(n)

Space Complexity: Stack of size n + ans[] array of size n = O(n) + O(n) = O(n)
*/

/*
Following 4 Questions are based of above parent problem:
1. Find the next greater element in the right in an array (https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1)
2. Find the previous greater element in the left in an array (https://www.geeksforgeeks.org/previous-greater-element/)
3. Find the next smaller element in the right in an array (https://www.geeksforgeeks.org/next-smaller-element/)
4. Find the previous smaller element in the left in an array (https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/)
*/
