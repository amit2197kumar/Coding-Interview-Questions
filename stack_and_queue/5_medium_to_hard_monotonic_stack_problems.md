# Medium To Hard Monotonic Stack Problems

### 1. [Next Greater Element](https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1) - Medium
```java
class Solution {
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) { 
        long[] nextLarger = new long[n];
        Stack<Long> stack = new Stack<>();
        
        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek()<=arr[i]) // Corner case: <= is correct & just < is incorrect 
                stack.pop();
            
            // Corner case: Stack was not empty inicially, but no element of stack is larger then curr element
            nextLarger[i] = stack.isEmpty() ? -1 : stack.peek();
            
            stack.push(arr[i]);
        }
        return nextLarger;
    } 
    // TC: O(n)
    // SC: O(n)
}
```

### 2. [Next Greater Element 2](https://www.geeksforgeeks.org/problems/next-greater-element-2/1) - Medium
```java
class Solution {
    // This problem is an extension of https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
    static int[] nextGreaterElement(int n, int arr[]) {
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i=2*n-1; i>=0; i--) { // why i=2*n-1? Think
            while(!stack.isEmpty() && stack.peek()<=arr[i%n]) 
                stack.pop();
                
            if (i<n) {
                nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(arr[i%n]);
        }
        
        return nextGreater;
    }
    // TC: O(n)
    // SC: O(n)
}
```

### 3. [Smallest number on left](https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1) - Medium
```java
class Solution {
    static List<Integer> leftSmaller(int n, int arr[]) {
        List leftSmaller = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<n; i++) {
            while(!stack.isEmpty() && stack.peek()>=arr[i])
                stack.pop();
                
            if (stack.isEmpty())
                leftSmaller.add(-1);
            else
                leftSmaller.add(stack.peek());
                
            stack.push(arr[i]);
        }
        return leftSmaller;
    }
    //TC: O(n)
    //SC: O(n)
}
```

### 4. [Asteroid Collision](https://www.geeksforgeeks.org/problems/asteroid-collision/1) - Hard
```java
class Solution {
    // NEG_NUM -> asteroid move left
    // POS_NUM -> asteroid move right
    // Speed of all asteroid is same so no need to compare two asteroid with same sign
    public static int[] asteroidCollision(int N, int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<N; i++) {
            // Keep pushing all POS asteroid in stack
            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {
                // Check all case only when NEG asteroid is found
                
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(asteroids[i])) {
                    // POP/Destory all small asteroid from top of stack
                    stack.pop();
                }
                
                //Stack empty || Same sign (both asteroid NEG) - PUSH
                if (stack.isEmpty() || stack.peek()<0) {
                    stack.push(asteroids[i]);
                }
                
                // Equal asteroid - both destroyed
                if (!stack.isEmpty() && stack.peek()==Math.abs(asteroids[i])) {
                     stack.pop();
                }
            }
        }
        
        int[] ans = new int[stack.size()];
        int i = stack.size()-1;
        
        while(!stack.isEmpty()) {
            ans[i--] = stack.pop();
        }
        return ans;
    }
    // TC: O(n)
    // SC: O(n)
}

```

### 5. [Remove K Digits](https://www.geeksforgeeks.org/problems/remove-k-digits/1) - Hard
```java
class Solution {
    //Explanation: https://youtu.be/cFabMOnJaq0
    public String removeKdigits(String number, int K) {
        Stack<Character> stack = new Stack<>();
        
        for (int i=0; i<number.length(); i++) {
            char currDigit = number.charAt(i);
            
            while(!stack.isEmpty() && K>0 && stack.peek()>currDigit) {
                stack.pop();
                K--;
            }
            stack.push(currDigit);
        }
        
        // Remove remaining k digits from the end of the stack
        while(K>0 && !stack.isEmpty()) {
            stack.pop();
            K--;
        }
        
        // Construct the resulting string from the stack
        StringBuilder smallNumber = new StringBuilder();
        while (!stack.isEmpty()) {
            smallNumber.append(stack.pop());
        }
        // Reverse to get the correct order
        smallNumber.reverse(); 
        
        // Remove leading zeros
        while (smallNumber.length()>0 && smallNumber.charAt(0)=='0') {
            smallNumber.deleteCharAt(0);
        }
        
        // Handle edge case where result might be empty
        return smallNumber.length() > 0 ? smallNumber.toString() : "0";
    }
    //TC: O(n)
    //SC: O(n)
}
```

### 6. [Maximum Rectangular Area in a Histogram](https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1) - Hard
```java
class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) {
        
        long[] width = new long[(int)n];
        long maxArea = Integer.MIN_VALUE;
        
        int[] rightSmaller = rightSmaller((int)n, hist);
        int[] leftSmaller = leftSmaller((int)n, hist);
        
        for (int i=0; i<n; i++) {
            width[i] = rightSmaller[i] - leftSmaller[i] - 1;
            width[i] = width[i] * hist[i];
            
            maxArea = maxArea > width[i] ? maxArea : width[i];
        }
        
        return maxArea;
    }
    
    public static int[] rightSmaller(int N, long[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] rightSmaller = new int[N];
        
        for (int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                rightSmaller[i] = N;
            } else {
                rightSmaller[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return rightSmaller;
    }
    
    public static int[] leftSmaller(int N, long[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[N];
        
        for (int i=0; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                leftSmaller[i] = -1;
            } else {
                leftSmaller[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return leftSmaller;
    }
    //TC: O(n)
    //SC: O(n)
}
```

### 7. [Maximal Rectangle](https://www.geeksforgeeks.org/problems/max-rectangle/1) - Hard
```java
class Solution {
    public int maxArea(int matrix[][], int n, int m) {
        int[] arr = new int[m];
        int maxRec = Integer.MIN_VALUE;
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (matrix[i][j]==0) {
                    arr[j]=0;
                } else {
                    arr[j]+=matrix[i][j];
                }
            }
            
            int currMax = getMaxArea(arr, m);
            maxRec = Math.max(maxRec, currMax);
        }
        
        return maxRec;
    }
    
    public static int getMaxArea(int hist[], int n) {
        
        int[] width = new int[n];
        int maxArea = Integer.MIN_VALUE;
        
        int[] rightSmaller = rightSmaller((int)n, hist);
        int[] leftSmaller = leftSmaller((int)n, hist);
        
        for (int i=0; i<n; i++) {
            width[i] = rightSmaller[i] - leftSmaller[i] - 1;
            width[i] = width[i] * hist[i];
            
            maxArea = maxArea > width[i] ? maxArea : width[i];
        }
        
        return maxArea;
    }
    
    public static int[] rightSmaller(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] rightSmaller = new int[N];
        
        for (int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                rightSmaller[i] = N;
            } else {
                rightSmaller[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return rightSmaller;
    }
    
    public static int[] leftSmaller(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[N];
        
        for (int i=0; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                leftSmaller[i] = -1;
            } else {
                leftSmaller[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return leftSmaller;
    }
    //Time Complexity: O(n*m)
    //Space Complexity: O(m+n)
}
```

### 8. [Sum of subarray minimum](https://www.geeksforgeeks.org/problems/sum-of-subarray-minimum/1) - Hard
```java
class Solution {
    public static int sumSubarrayMins(int N, int[] arr) {
        int[] rightSmaller = rightSmaller(N, arr);
        int[] leftSmaller = leftSmaller(N, arr);
        int mod = 1000000000 + 7;
        long sum = 0;
        
        for (int i=0; i<N; i++) {
            sum += (long)((((i-leftSmaller[i])*(rightSmaller[i]-i)) % mod) * arr[i]) % mod;
            sum %= mod;
        }
        
        return (int)sum;
    }

    public static int[] rightSmaller(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] rightSmaller = new int[N];
        
        for (int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                rightSmaller[i] = N;
            } else {
                rightSmaller[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return rightSmaller;
    }
    
    public static int[] leftSmaller(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[N];
        
        for (int i=0; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                leftSmaller[i] = -1;
            } else {
                leftSmaller[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return leftSmaller;
    }
    //TC: O(n)
    //SC: O(n)
}
```

### 9. [Sum of Subarray Ranges](https://www.geeksforgeeks.org/problems/sum-of-subarray-ranges/1) - Hard
```java
class Solution {
    //TC: O(n)
    //SC: O(n)
    
    public static long subarrayRanges(int N, int[] arr) {
        long sumSubarrayMins  = sumSubarrayMins(N, arr);
        long sumSubarrayMaxs  = sumSubarrayMaxs(N, arr);
        
        return sumSubarrayMaxs - sumSubarrayMins;
    }
    
    /*********************Sum Of Subarray Minimum***********************/
    
    public static long sumSubarrayMins(int N, int[] arr) {
        int[] rightSmaller = rightSmaller(N, arr);
        int[] leftSmaller = leftSmaller(N, arr);
        int mod = 1000000000 + 7;
        long sum = 0;
        
        for (int i=0; i<N; i++) {
            sum += (long)((((i-leftSmaller[i])*(rightSmaller[i]-i)) % mod) * arr[i]) % mod;
            sum %= mod;
        }
        
        return sum;
    }
    
    public static int[] rightSmaller(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] rightSmaller = new int[N];
        
        for (int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                rightSmaller[i] = N;
            } else {
                rightSmaller[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return rightSmaller;
    }
    
    public static int[] leftSmaller(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] leftSmaller = new int[N];
        
        for (int i=0; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                leftSmaller[i] = -1;
            } else {
                leftSmaller[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return leftSmaller;
    }
    
    /*******************************************************************/
    /*********************Sum Of Subarray Maximum***********************/
    
    public static long sumSubarrayMaxs(int N, int[] arr) {
        int[] rightGreater = rightGreater(N, arr);
        int[] leftGreater = leftGreater(N, arr);
        int mod = 1000000000 + 7;
        long sum = 0;
        
        for (int i=0; i<N; i++) {
            sum += (long)((((i-leftGreater[i])*(rightGreater[i]-i)) % mod) * arr[i]) % mod;
            sum %= mod;
        }
        
        return sum;
    }
    
    public static int[] rightGreater(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] rightGreater = new int[N];
        
        for (int i=N-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                rightGreater[i] = N;
            } else {
                rightGreater[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return rightGreater;
    }
    
    public static int[] leftGreater(int N, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] leftGreater = new int[N];
        
        for (int i=0; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                leftGreater[i] = -1;
            } else {
                leftGreater[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return leftGreater;
    }
    
    /*******************************************************************/
}

```
### 10. [K-Sized Subarray Maximum](https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1)
```java
// This problem can be done via HEAP with TC of O(N*k)
// Using Deque (DLL Queue) we can reduce TC to O(N)
class Solution {
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k) {
        
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> win = new ArrayDeque<>();
        
        for (int i=0; i<n; i++) {
            // remove indices that are out of bound
            while(win.size()>0 && win.peekFirst()<=i-k)
                win.pollFirst();
            
            // remove indices whose corresponding values are less than nums[i]    
            while (win.size() > 0 && arr[win.peekLast()]<arr[i])
                win.pollLast();
                
            // add nums[i]
            win.offerLast(i);
            
            // add to result
            if (i>=k-1) {
                result.add(arr[win.peekFirst()]);
            }
        }
        return result;
    }
    // TC: O(n)
    // SC: O(1)
}
```

### 11. [Stock span problem](https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1)
```java
class Solution {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        int[] leftGreater = leftGreater(price, n);
        for (int i=0; i<n; i++) {
            leftGreater[i] = i - leftGreater[i];
        }
        return leftGreater;
    }
    
    public static int[] leftGreater(int arr[], int N) {
        Stack<Integer> stack = new Stack<>();
        int[] leftGreater = new int[N];
        
        for (int i=0; i<N; i++) {
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                leftGreater[i] = -1;
            } else {
                leftGreater[i] = stack.peek();
            }
            
            stack.push(i);
        }
        return leftGreater;
    }
    // TC: O(n)
    // SC: O(n)
}
```
### 12. [The Celebrity Problem](https://www.geeksforgeeks.org/problems/the-celebrity-problem/1)
```java
class Solution { 
    //Function to find if there is a celebrity in the party or not.
    //Understand that their can't be more then 1 celebrity ever
    int celebrity(int M[][], int n) {
    	Stack<Integer> stack = new Stack<>();
    	for (int i=0; i<n; i++) {
    	    stack.push(i);
    	}
    	
    	while(stack.size()>=2) {
    	    int i=stack.pop();
    	    int j=stack.pop();
    	    
    	    if (M[i][j] == 1) {
    	        //i knows j -> i can't be a celebrity
    	        stack.push(j);
    	    } else {
    	        //i don't know j -> j can't be a celebrity
    	        stack.push(i);
    	    }
    	}
    	
    	int potCel = stack.pop();
    	for (int i=0; i<n; i++) {
    	    if (i!=potCel) { // no need to check digonals
    	    
    	        if (M[i][potCel] !=1 || M[potCel][i] == 1) {
    	            // i don't know potCel OR potCel knows i -> potCel is not a celebrity
    	            return -1;
    	        }
    	    }
    	}
    	
    	return potCel;
    }
    // TC: O(n)
    // SC: O(n)
}
```