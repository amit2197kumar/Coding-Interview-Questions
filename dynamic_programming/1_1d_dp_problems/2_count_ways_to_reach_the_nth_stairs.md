# Count Ways To Reach The N-th Stairs

Practice Problem: [Count Ways To Reach The N-th Stairs](https://www.naukri.com/code360/problems/count-ways-to-reach-the-n-th-stairs_798650)

This Problem Is Simlar To [Nth Fibonacci Number](https://www.naukri.com/code360/problems/nth-fibonacci-number_74156)

## Recursion

```java
static int mod = 1000000007;
public static long countDistinctWayToClimbStair(long nStairs) {
    if (nStairs == 0) return 1;
    if (nStairs == 1) return 1;

    return (countDistinctWayToClimbStair(nStairs - 1) + countDistinctWayToClimbStair(nStairs - 2)) % mod;
}
```

**Time Complexity:** `O(2^N)`

The time complexity of this approach is exponential, specifically O(2^N), where N is the number of stairs. This is because for each stair, two recursive calls are made (except for the base cases). As a result, the number of function calls grows exponentially with the number of stairs.

**Space Complexity:** `O(2^N)`

The space complexity is also exponential due to the recursion. Each recursive call consumes space on the call stack. Since there are potentially two recursive calls at each level of the recursion tree until it reaches the base cases, the space complexity is O(2^N), where N is the number of stairs.

## Iterative With Tabulation [Bottom-Up] - Space Optimized

```java
static int mod = 1000000007;
public static long countDistinctWayToClimbStair(long nStairs) {
    long prev_1 = 1;
    long prev_2 = 1;
    long curr = 0;

    for (long i = 2; i <= nStairs; i++) {
        curr = (prev_1 + prev_2) % mod; // % mod is needed as sum can surpass the long value range

        prev_1 = prev_2;
        prev_2 = curr;
    }
    return prev_2;
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the number of stairs. This is because the loop iterates from 2 to nStairs, performing constant-time operations in each iteration. Since the loop iterates through each stair once, the time complexity is linear.

**Space Complexity:** `O(1)`

The space complexity is O(1), which means it's constant. This is because the space used by the variables prev_1, prev_2, and curr does not depend on the input size. Regardless of the input value nStairs, only a constant amount of space is used.