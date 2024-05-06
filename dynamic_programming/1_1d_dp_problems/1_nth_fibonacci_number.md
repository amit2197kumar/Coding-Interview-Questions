# Nth Fibonacci Number

Practice Problem: [Nth Fibonacci Number](https://www.naukri.com/code360/problems/nth-fibonacci-number_74156)

## Recursion

```java
public static int getFibonacci(int val) {
    if (val <= 1)
        return val;

    return getFibonacci(val - 1) + getFibonacci(val - 2);
}
```
**Time Complexity:** `O(2^N)`

The time complexity of this recursive Fibonacci algorithm is exponential. Each call to getFibonacci() results in two recursive calls (except for the base cases), leading to a binary tree of recursive calls. The number of function calls grows exponentially with the input value val. Specifically, it's O(2^N), where N is the input value val.

**Space Complexity:** `O(2^N)`

The space complexity is also exponential because of the recursive calls. Each recursive call consumes space on the call stack. Since there are potentially two recursive calls at each level of the recursion tree until it reaches the base cases, the space complexity is also O(2^N).

## Recursion With Memorization [Top-Down]

```java
public static int getFibonacci(int val) {
    int[] dp = new int[val + 1];
    setDefaultDpArrayValue(dp);
    return getFibonacciUtil(val, dp);
}

public static int getFibonacciUtil(int val, int[] dp) {
    if (val <= 1) return val;

    if (dp[val] != -1)
        return dp[val];

    dp[val] = getFibonacci(val - 1) + getFibonacci(val - 2);
    return dp[val];
}

public static void setDefaultDpArrayValue(int[] array) {
    for (int i = 0; i < array.length; i++) {
        array[i] = -1;
    }
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the input value val. This is because each value of the Fibonacci sequence from 2 to val is computed only once, and then stored in the dp array. Subsequent calls to Fibonacci numbers are retrieved from the dp array, which takes constant time.

**Space Complexity:** `O(N)`

The space complexity is O(N) as well. This is because of the additional space required to store the dp array of size val + 1, where each element represents a Fibonacci number. Additionally, the space complexity includes the space used by the call stack for the recursive calls, but since the recursion has been eliminated by using memoization, the call stack depth will not exceed O(N), where N is the input value val.

## Iterative With Tabulation [Bottom-Up]

```java
public static int getFibonacci(int val) {
    int[] dp = new int[val + 1];
    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i < dp.length; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[val];
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the input value val. This is because the code iterates val times to fill up the dp array. In each iteration, a constant amount of work is done.

**Space Complexity:** `O(N)`

The space complexity is O(N). This is because of the additional space required to store the dp array of size val + 1, where each element represents a Fibonacci number. The space complexity does not depend on the input size beyond the dp array's size.

## Iterative With Tabulation [Bottom-Up] - Space Optimized

```java
public static int getFibonacci(int val) {
    int prev_1 = 0;
    int prev_2 = 1;
    int curr = 0;

    for (int i = 2; i <= val; i++) {
        curr = prev_1 + prev_2;

        prev_1 = prev_2;
        prev_2 = curr;
    }
    return prev_2;
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the input value val. This is because the loop iterates val - 1 times (from 2 to val) to calculate the Fibonacci number at index val. In each iteration, constant time operations are performed.

**Space Complexity:** `O(1)`

The space complexity is O(1), which means it's constant. This is because the space used by the variables prev_1, prev_2, and curr does not depend on the input size. Regardless of the input value val, only a constant amount of space is used.