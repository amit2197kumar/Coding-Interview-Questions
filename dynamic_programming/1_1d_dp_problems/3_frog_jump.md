# Frog Jump

Practice Problem: [Frog Jump](https://www.naukri.com/code360/problems/frog-jump_3621012)

## Recursion

```java
public class Solution {
    public static int frogJump(int n, int heights[]) {
        return frogJumpUtil(n - 1, heights);
    }

    public static int frogJumpUtil(int n, int heights[]) {
        if (n == 0)
            return 0;

        int left = frogJumpUtil(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE;

        if (n > 1) {
            right = frogJumpUtil(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }

        return Math.min(left, right);
    }
}
```

**Time Complexity:** `O(2^N)`

The time complexity of this recursive approach is exponential, specifically O(2^N), where N is the number of heights. This is because for each height, two recursive calls are made (except for the base case). As a result, the number of function calls grows exponentially with the number of heights.

**Space Complexity:** `O(2^N)`

The space complexity is also exponential due to the recursion. Each recursive call consumes space on the call stack. Since there are potentially two recursive calls at each level of the recursion tree until it reaches the base case, the space complexity is O(2^N), where N is the number of heights.

## Recursion With Memorization [Top-Down]

```java
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n + 1];
        setDpArray(dp);
        return frogJumpUtil(n - 1, heights, dp);
    }

    public static int frogJumpUtil(int n, int[] heights, int[] dp) {
        if (n == 0) return 0;

        if (dp[n] != -1)
            return dp[n];

        int left = frogJumpUtil(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int right = Integer.MAX_VALUE; // Edge case when n is 1, can't do heights[n - 2]

        if (n > 1) {
            right = frogJumpUtil(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        }

        dp[n] = Math.min(left, right);
        return dp[n];
    }

    public static void setDpArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the number of heights. This is because the function frogJumpUtil() is called once for each height, and each height's calculation is stored in the dp array. Since the calculation for each height is performed only once, the time complexity is linear.

**Space Complexity:** `O(N)`

The space complexity is O(N), where N is the number of heights. This is because of the additional space required to store the dp array of size n + 1, where each element represents the minimum energy required to reach that height. Additionally, the space complexity includes the space used by the call stack for the recursive calls, but since the recursion has been optimized using memoization, the call stack depth will not exceed O(N).

## Iterative With Tabulation [Bottom-Up]

```java
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;

            if (i > 1) {
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }

        return dp[n - 1];
    }
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the number of heights. This is because the loop iterates through the heights once, from 1 to n - 1, performing constant-time operations in each iteration. Since the loop iterates through each height once, the time complexity is linear.

**Space Complexity:** `O(N)`

The space complexity is O(N), where N is the number of heights. This is because of the additional space required to store the dp array of size n, where each element represents the minimum energy required to reach that height. The space complexity does not depend on the input size beyond the dp array's size.

## Iterative With Tabulation [Bottom-Up] - Space Optimized

```java
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        int prev_1 = 0;
        int prev_2 = 0;

        for (int i = 1; i < n; i++) {
            int left = prev_1 + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;

            if (i > 1) {
                right = prev_2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curr = Math.min(left, right);
            prev_2 = prev_1;
            prev_1 = curr;
        }

        return prev_1;
    }
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the number of heights. This is because the loop iterates through the heights once, from 1 to n - 1, performing constant-time operations in each iteration. Since the loop iterates through each height once, the time complexity is linear.

**Space Complexity:** `O(1)`

The space complexity is O(1), which means it's constant. This is because the space used by the variables prev_1 and prev_2 does not depend on the input size. Regardless of the input value n, only a constant amount of space is used.