#  Minimal Cost (Frog Jump With K Distances)

Practice Problem: [Minimal Cost (Frog Jump With K Distances)](https://www.naukri.com/code360/problems/minimal-cost_8180930)

## Recursion

```java
public class Solution {
    public static int minimizeCost(int n, int k, int[] height) {
        return minimizeCostUtil(n - 1, k, height);
    }

    public static int minimizeCostUtil(int n, int k, int[] height) {
        if (n == 0)
            return 0;

        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int currMinCost = minimizeCostUtil(n - i, k, height) + Math.abs(height[n] - height[n - i]);
                minCost = Math.min(minCost, currMinCost);
            }
        }

        return minCost;
    }
}
```

**Time Complexity:** `O(k^N)`

The time complexity of this approach is exponential. For each height, it explores up to k possible jumps backward. Therefore, the number of recursive calls grows exponentially with the input size n and the maximum jump size k. The time complexity can be represented as O(k^N), where N is the number of heights. However, the actual time complexity could be lower depending on the distribution of the heights and the value of k.

**Space Complexity:** `O(k^N)`

The space complexity is also exponential due to the recursion. Each recursive call consumes space on the call stack. Since there are potentially k recursive calls at each level of the recursion tree, and the tree can go as deep as the number of heights, the space complexity is exponential.

## Recursion With Memorization [Top-Down]

```java
public class Solution {
    public static int minimizeCost(int n, int k, int[] height) {
        int[] dp = new int[n + 1];
        setDpArray(dp);
        return minimizeCostUtil(n - 1, k, height, dp);
    }

    public static int minimizeCostUtil(int n, int k, int[] height, int[] dp) {
        if (n == 0)
            return 0;

        if (dp[n] != -1)
            return dp[n];

        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            if (n - i >= 0) {
                int currMinCost = minimizeCostUtil(n - i, k, height, dp) + Math.abs(height[n] - height[n - i]);
                minCost = Math.min(minCost, currMinCost);
            }
        }

        dp[n] = minCost;
        return dp[n];
    }

    public static void setDpArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = -1;
        }
    }
}
```

**Time Complexity:** `O(N * K)`

The time complexity of this approach is O(N * K), where N is the number of heights and K is the maximum jump size. This is because each entry in the dp array is computed only once, and each computation involves a loop of size K. Therefore, the total number of computations is proportional to the product of N and K.

**Space Complexity:** `O(N)`

The space complexity is O(N), where N is the number of heights. This is because of the additional space required to store the dp array of size n + 1, where each element represents the minimum cost to reach that height. Additionally, the space complexity includes the space used by the call stack for the recursive calls, but since the recursion has been optimized using memoization, the call stack depth will not exceed O(N).

## Iterative With Tabulation [Bottom-Up]

```java
public class Solution {
    public static int minimizeCost(int n, int k, int[] height) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int currMinCost = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    minCost = Math.min(minCost, currMinCost);
                }
            }
            dp[i] = minCost;
        }

        return dp[n - 1];
    }
}
```

**Time Complexity:** `O(N * K)`

The time complexity of this approach is O(N * K), where N is the number of heights and K is the maximum jump size. This is because for each height, the algorithm iterates over the last K heights (or less if K is greater than i), calculating the cost for each possible jump and updating the dp array accordingly. Therefore, the total number of computations is proportional to the product of N and K.

**Space Complexity:** `O(N)`

The space complexity is O(N), where N is the number of heights. This is because of the additional space required to store the dp array of size n, where each element represents the minimum cost to reach that height. The space complexity does not depend on the input size beyond the dp array's size.

**Iterative With Tabulation [Bottom-Up] - Space Optimized - NOT POSSIBLE**
