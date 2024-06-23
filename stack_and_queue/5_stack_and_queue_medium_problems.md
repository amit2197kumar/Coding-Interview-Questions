# Stack And Queue Medium Problems

### 1. [Next Greater Element](https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1)
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
### 2. [Next Greater Element 2](https://www.geeksforgeeks.org/problems/next-greater-element-2/1)
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