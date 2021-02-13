/*
Company Tags:  Amazon Apple Flipkart Microsoft
Practice Portal:
GeeksForGeeks: https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
*/

/*
A brute-force solution would be to try all possible subset with all different fraction but that will be too much time taking.

An efficient solution is to use Greedy approach. The basic idea of the greedy approach is to calculate the ratio value/weight
for each item and sort the item on basis of this ratio. Then take the item with the highest ratio and add them until we can’t
add the next item as a whole and at the end add the next item as much as we can. Which will always be the optimal solution to this problem.

Must read: https://afteracademy.com/blog/fractional-knapsack-problem
See: https://youtu.be/oTTzNMHM05I
*/

class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double i1 = (double)a.value/(double)a.weight;
        double i2 = (double)b.value/(double)b.weight;
        if(i1 < i2) {
            return 1;
        } else if(i1 > i2) {
            return -1;
        } else {
            return 0;
        }
    }
}

class solve{
    double fractionalKnapsack(int W, Item arr[], int n) {

        Arrays.sort(arr, new itemComparator());

        double ans = 0;
        int curr = 0;

        for(int i = 0 ; i < n ; i++) {
            if(curr + arr[i].weight <= W) {
                curr =  curr + arr[i].weight;
                ans = ans + arr[i].value;
            } else {
                int remaining = W - curr;
                ans = ans + ((double)arr[i].value/(double)arr[i].weight) * (double)remaining;
                break;
            }
        }

        return ans;
    }
}

/*
Time Complexity: Time complexity of the sorting + Time complexity of the loop to maximize profit = O(NlogN) + O(N) = O(NlogN)
Space Complexity: O(1)
*/