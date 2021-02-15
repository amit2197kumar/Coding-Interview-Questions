/*
Company Tags: Amazon Directi Intuit MakeMyTrip Microsoft Samsung
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/max-rectangle/1
*/

//Parent Problem: Find the next greater element in the right in an array
//PARENT PROBLEM : Largest Rectangular Area in a Histogram

/*
Must see: https://youtu.be/St0Jf_VmG_g?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
*/

class GfG {
    public int maxArea(int matrix[][], int m, int n) {
        int[] histogram = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            histogram[i] = matrix[0][i];
            maxArea = getMaxArea(histogram, n);
        }

        for (int i=1; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (matrix[i][j] == 0) {
                    histogram[j] = 0;
                } else {
                    histogram[j] = histogram[j] + matrix[i][j];
                }
            }

            int currMaxArea = getMaxArea(histogram, n);
            maxArea = maxArea > currMaxArea ? maxArea : currMaxArea;
        }
        return maxArea;
    }

    public int getMaxArea(int hist[], int n)  {
        int[] width = new int[n];
        int maxArea = Integer.MIN_VALUE;

        int[] rightSmaller = getRightSmaller(hist, n);
        int[] leftSmaller = getLeftSmaller(hist, n);

        for (int i=0; i<n; i++) {
            width[i] = rightSmaller[i] - leftSmaller[i] - 1;
            width[i] = width[i] * hist[i];

            maxArea = maxArea > width[i] ? maxArea : width[i];
        }

        return maxArea;
    }

    public static int[] getRightSmaller(int hist[], int n) {
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

    public static int[] getLeftSmaller(int hist[], int n) {
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
Time Complexity: Traversal of the array and Stack Manipulation = O(n * n)
Space Complexity:  = O(n)
*/