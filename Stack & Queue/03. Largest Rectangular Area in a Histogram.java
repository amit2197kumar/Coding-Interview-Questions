/*
Company Tags:  Amazon Apple Flipkart Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
*/

/*
Parent Problem :
1. Find the next smaller element in the right in an array (https://www.geeksforgeeks.org/next-smaller-element/)
2. Find the previous smaller element in the left in an array (https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/)
*/

/*
Must See:
1. https://youtu.be/J2X70jj_I1o?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
2. https://youtu.be/0do2734xhnU
*/


class solve{

    public static long getMaxArea(long hist[], long n)  {
        long[] width = new long[(int)n];
        long maxArea = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            width[i] = rightSmaller[i] - leftSmaller[i] - 1;
            width[i] = width[i] * hist[i];

            maxArea = maxArea > width[i] ? maxArea : width[i];
        }

        return maxArea;
    }

    public static int[] getRightSmaller(long hist[], int n) {
        int[] rightSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=n-1; i>=0; i--) {
            if (stack.isEmpty()) {
                rightSmaller[i] = n;
            } else {
                while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
                    stack.pop();

                if (stack.isEmpty()) {
                    rightSmaller[i] = n;
                } else {
                    rightSmaller[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return rightSmaller;
    }

    public static int[] getLeftSmaller(long hist[], int n) {
        int[] leftSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<n; i++) {
            if (stack.isEmpty()) {
                leftSmaller[i] = -1;
            } else {
                while (!stack.isEmpty() && hist[stack.peek()] >= hist[i])
                    stack.pop();

                if (stack.isEmpty()) {
                    leftSmaller[i] = -1;
                } else {
                    leftSmaller[i] = stack.peek();
                }
            }
            stack.push(i);
        }
        return leftSmaller;
    }
}

/*
Time Complexity: Traversal of the array and Stack Manipulation = O(2*n) (Why?) = O(n)
Space Complexity:  = O(n)
*/


