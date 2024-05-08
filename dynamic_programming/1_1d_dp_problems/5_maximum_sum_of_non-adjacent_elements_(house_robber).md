#  Maximum Sum Of Non-adjacent Elements (House Robber)

Practice Problem: [Maximum Sum Of Non-adjacent Elements (House Robber)](https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261)

## Recursion

```java
public class Solution {
    public static int maximumNonAdjacentSum(ArrayList < Integer > nums) {
        return maximumNonAdjacentSumUtil(nums.size() - 1, nums);
    }

    public static int maximumNonAdjacentSumUtil(int index, ArrayList < Integer > nums) {
        if (index == 0)
            return nums.get(0);

        if (index < 0)
            return 0;

        int picked = nums.get(index) + maximumNonAdjacentSumUtil(index - 2, nums);
        int notPicked = maximumNonAdjacentSumUtil(index - 1, nums);

        return Math.max(picked, notPicked);
    }
}
```

**Time Complexity:** `O(2^N)`

The time complexity of this approach is exponential, specifically O(2^N), where N is the number of elements in the ArrayList. This is because each call to maximumNonAdjacentSumUtil() results in two recursive calls (except for the base cases), leading to a binary tree of recursive calls. The number of function calls grows exponentially with the size of the input ArrayList.

**Space Complexity:** `O(2^N)`

The space complexity is also exponential due to the recursion. Each recursive call consumes space on the call stack. Since there are potentially two recursive calls at each level of the recursion tree until it reaches the base cases, the space complexity is O(2^N), where N is the number of elements in the ArrayList.

## Recursion With Memorization [Top-Down]

```java
public class Solution {
    public static int maximumNonAdjacentSum(ArrayList < Integer > nums) {
        int[] dp = new int[nums.size() + 1];
        setDpArray(dp);
        return maximumNonAdjacentSumUtil(nums.size() - 1, nums, dp);
    }

    public static int maximumNonAdjacentSumUtil(int index, ArrayList < Integer > nums, int[] dp) {
        if (index == 0)
            return nums.get(0);

        if (index < 0)
            return 0;

        if (dp[index] != -1) {
            return dp[index];
        }

        int picked = nums.get(index) + maximumNonAdjacentSumUtil(index - 2, nums, dp);
        int notPicked = maximumNonAdjacentSumUtil(index - 1, nums, dp);

        dp[index] = Math.max(picked, notPicked);
        return dp[index];
    }

    public static void setDpArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the number of elements in the ArrayList. This is because each element of the ArrayList is processed only once, and each computation involves a constant number of operations. Since memoization ensures that each index is computed only once, the total number of computations is proportional to the size of the input.

**Space Complexity:** `O(N)`

The space complexity is O(N), where N is the number of elements in the ArrayList. This is because of the additional space required to store the dp array of size nums.size() + 1, where each element represents the maximum sum of non-adjacent elements up to that index. Additionally, the space complexity includes the space used by the call stack for the recursive calls, but since the recursion has been optimized using memoization, the call stack depth will not exceed O(N).

## Iterative With Tabulation [Bottom-Up]

```java
public class Solution {
    public static int maximumNonAdjacentSum(ArrayList < Integer > nums) {
        int[] dp = new int[nums.size()];

        dp[0] = nums.get(0);
        int neg = 0;

        for (int i = 1; i < nums.size(); i++) {
            int picked = nums.get(i) + (i - 2 >= 0 ? dp[i - 2] : neg);
            int notPicked = dp[i - 1];

            dp[i] = Math.max(picked, notPicked);
        }
        return dp[nums.size() - 1];
    }
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the number of elements in the ArrayList. This is because the loop iterates through the ArrayList once, from the second element to the last, performing constant-time operations in each iteration.

**Space Complexity:** `O(N)`

The space complexity is O(N), where N is the number of elements in the ArrayList. This is because of the additional space required to store the dp array of size nums.size(), where each element represents the maximum sum of non-adjacent elements up to that index. The space complexity does not depend on the input size beyond the dp array's size.

## Iterative With Tabulation [Bottom-Up] - Space Optimized

```java
public class Solution {
    public static int maximumNonAdjacentSum(ArrayList < Integer > nums) {
        int prev_1 = nums.get(0);
        int prev_2 = 0;

        for (int i = 1; i < nums.size(); i++) {
            int picked = nums.get(i) + prev_2;
            int notPicked = prev_1;

            int currMax = Math.max(picked, notPicked);
            prev_2 = prev_1;
            prev_1 = currMax;
        }
        return Math.max(prev_1, prev_2);
    }
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the number of elements in the ArrayList. This is because the loop iterates through the ArrayList once, from the second element to the last, performing constant-time operations in each iteration.

**Space Complexity:** `O(1)`

The space complexity is O(1), which means it's constant. This is because the space used by the variables prev_1 and prev_2 does not depend on the input size. Regardless of the input size, only a constant amount of space is used.