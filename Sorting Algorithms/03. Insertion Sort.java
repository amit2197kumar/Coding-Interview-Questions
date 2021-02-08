/*
Company Tags:  Medlife
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/selection-sort/1
*/

/*
Insertion sort is a simple sorting algorithm that works similar to the way you sort playing cards in your hands.

Algorithm
To sort an array of size n in ascending order:
1: Iterate from arr[1] to arr[n] over the array.
2: Compare the current element (key) to its predecessor.
3: If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.
*/

class InsertionSort
{
    static void insert(int arr[],int n) {
        for (int i=1; i<=n; i++) {

            int curr = arr[i];
            int j = i-1;

            while (j >= 0 && arr[j] > curr) {
                arr[j+1] = arr[j--];
            }

            arr[j+1] = curr;
        }
    }
}

/*
Time Complexity: O(n^2)
Auxiliary Space: O(1)
Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
Algorithmic Paradigm: Incremental Approach
Sorting In Place: Yes
Stable: Yes
Online: Yes
Uses: Insertion sort is used when number of elements is small. It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
*/