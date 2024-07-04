# Stack & Queue Cheat Sheet

## A must read Articles
1. [A comprehensive guide and template for monotonic stack based problems](https://leetcode.com/discuss/study-guide/2347639/A-comprehensive-guide-and-template-for-monotonic-stack-based-problems)
2. [A general approach to Stack problems in C++ | Generic Template](https://leetcode.com/discuss/study-guide/3168516/A-general-approach-to-stack-problems-in-C%2B%2B-or-Generic-Template)

## Corner cases
1. Always check if the stack/queue is empty before processing over it.
2. While checking peek() in stack/queue take care of ≤ or just <

## When to use stack?
1. Monotonic Stack: Can identifying left and right smaller or greater elements simplify the current problem?
2. LIFO order is required
3. Processing order matters
4. Only need access to top element
5. Reversing structures like strings

## Practice Identifying Data Structure Usage
- Do I need to access elements in the reverse order of their insertion? (Stack)
- Do I need to access elements in the same order as their insertion? (Queue)
- Am I dealing with nested structures or need to backtrack? (Stack)
- Am I processing elements level by level or in a sequence? (Queue)