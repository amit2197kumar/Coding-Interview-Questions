# What is Dynamic Programming?

Dynamic Programming → Enhanced Recursion (Recursion + Overlapping)

Remember : PARENT of Dynamic Programming is RECURSION.

# How to identify the Dynamic Programming Questions

1. We will also get a choice to choose in the problem statement.
2. We will be asked to get an Optimal Solution : Get Minimum, Maximum, Largest, Smallest
3. 2 Recursion function calls (with Overlapping)

# Type of solution

1. Base Recursive Solution.
2. Memoization Solution (Top-Down) : Recursive Call + DP Matrix
3. Bottom-up Solution : DP Matrix. (We remove Recursive Call, so that we remove Recursive Stack & Stack Overflow)

[Recursive Solution] → [Top-Down Solution] → [Bottom-up Solution]

# Dynamic Programming Question:

1. 0-1 Knapsack Problem
    1. [0-1 Knapsack Problem](https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)
    2. [Subset Sum Problem](https://www.interviewbit.com/problems/subset-sum-problem/)
    3. [Partition Equal Subset Sum](https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1)
    4. [Count of subsets with sum equal to X](https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/)*
    5. [Minimum sum partition](https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1)**
    6. Count number of subset with given difference***
    7. [Target Sum](https://leetcode.com/problems/target-sum/)**
2. Unbounded Knapsack
    1. [Unbounded Knapsack](https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1)
    2. [Rod Cutting](https://www.techiedelight.com/rot-cutting/)
    3. [Coin Change](https://practice.geeksforgeeks.org/problems/coin-change2448/1)
    4. Minimum Coin Change [[GeeksForGeeks](https://practice.geeksforgeeks.org/problems/number-of-coins1824/1)][[LeetCode](https://leetcode.com/problems/coin-change/)]
    5. [Maximum Ribbon/Rod Cutting](https://practice.geeksforgeeks.org/problems/cutted-segments1642/1)
3. Longest Common Subsequence/Substring
    1. [Longest Common Subsequence](https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1)
    2. [Minimum number of deletions and insertions](https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1)
    3. [Shortest Common Supersequence](https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1)
    4. [Longest Repeating Subsequence](https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1)
    5. [Check for subsequence](https://practice.geeksforgeeks.org/problems/check-for-subsequence4930/1)
    6. [Minimum Deletions in a String to make it a Palindrome](https://practice.geeksforgeeks.org/problems/minimum-deletitions/0)
    7. [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
    8. [Edit Distance](https://practice.geeksforgeeks.org/problems/edit-distance3702/1)*
    9. [Longest Common Substring](https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1)
    10. [Longest Palindromic Substring](https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0)
4. Longest Increasing Subsequence
    1. Longest Increasing Subsequence[[GeeksForGeeks](https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1)][[LeetCode](https://leetcode.com/problems/longest-increasing-subsequence/)]**
    2. [Maximum Sum Increasing Subsequence](https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1)
    3. [Minimum Deletions to Make a Sequence Sorted](https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-to-make-a-sorted-sequence3248/1)
    4. [Longest Bitonic Subsequence](https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1)*
    5. [Count of Palindromic Substrings](https://practice.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string/0)**
5. Matrix Chain Multiplication
    1. [Matrix Chain Multiplication](https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1)**
    2. [Palindrome Partitioning](https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1)**
    3. [Evaluate Boolean Parenthesization/Expression To True](https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1)***
6. Fibonacci Numbers:
    1. [Fibonacci numbers](https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1)
    2. [Staircase](https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1)
    3. [Minimum jumps to reach the end](https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1)
    4. Minimum jumps with fee
    5. [House thief](https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1)
7. Best Time To Buy & Sell Stocks
    1. [Best Time to Buy and Sell Stock I](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
    2. [Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)
    3. [Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)
    4. [Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)
    5. [Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)
    6. [Best Time to Buy and Sell Stock with Transaction Fee](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)
8. Shortest Path!!