#  House Robber II

Practice Problem: [House Robber II](https://www.naukri.com/code360/problems/house-robber-ii_839733)

This Problem is an extenstion on [Maximum Sum Of Non-adjacent Elements (House Robber)](https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261). So we are directly looking into the iterative with tabulation [Bottom-Up] - space optimized solution. Recursion and Top-down approach are same as [Maximum Sum Of Non-adjacent Elements (House Robber)](https://www.naukri.com/code360/problems/maximum-sum-of-non-adjacent-elements_843261)

## Iterative With Tabulation [Bottom-Up] - Space Optimized

```java
public class Solution {
    public static long houseRobber(int[] valueInHouse) {
        int len = valueInHouse.length;

        if (len == 1) return valueInHouse[0];
        if (len == 2) return Math.max(valueInHouse[0], valueInHouse[1]);

        ArrayList < Integer > arr1 = new ArrayList < > (); // One array with 0th index skipped
        ArrayList < Integer > arr2 = new ArrayList < > (); // One array with nth index skipped

        for (int i = 0; i < len; i++) {
            if (i != 0) arr1.add(valueInHouse[i]);
            if (i != len - 1) arr2.add(valueInHouse[i]);
        }

        long value1 = maximumNonAdjacentSum(arr1);
        long value2 = maximumNonAdjacentSum(arr2);

        return Math.max(value1, value2);
    }

    // same solution as in problem "Maximum sum of non-adjacent elements"
    public static long maximumNonAdjacentSum(ArrayList < Integer > nums) {
        long prev_1 = nums.get(0);
        long prev_2 = 0;

        for (int i = 1; i < nums.size(); i++) {
            long picked = nums.get(i) + prev_2;
            long notPicked = prev_1;

            long currMax = Math.max(picked, notPicked);
            prev_2 = prev_1;
            prev_1 = currMax;
        }
        return Math.max(prev_1, prev_2);
    }
}
```

**Time Complexity:** `O(N)`

The time complexity of this approach is O(N), where N is the number of elements in the valueInHouse array. This is because the houseRobber method iterates through the valueInHouse array once to create two new ArrayLists (arr1 and arr2) without the 0th and nth elements, respectively. Then, it calls the maximumNonAdjacentSum method, which has a time complexity of O(N), where N is the size of the ArrayList.

**Space Complexity:** `O(N)`

The space complexity is O(N), where N is the number of elements in the valueInHouse array. This is because the code uses two ArrayLists (arr1 and arr2) to store the modified arrays without the 0th and nth elements. Additionally, within the maximumNonAdjacentSum method, it uses only two variables (prev_1 and prev_2), which require constant space.