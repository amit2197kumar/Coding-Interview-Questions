/*
Company Tags:  Amazon Arcesium
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/count-the-triplets4615/1
*/

/*
Sort the given array first.
Start fixing the greatest element of three from back and traverse the array to find other two numbers which sum upto the third element.
Take two pointers j(from front) and k(initially i-1) to find the smallest of the two number and from i-1 to find the largest of the two remaining numbers
*/

class Solution {
    int countTriplet(int arr[], int n) {
        bubbleSort(arr, n);
        int count = 0;

        for (int i=n-1; i>=0; i--) {
            for (int j=0, k=i; j<k; ) {
                if (arr[j] + arr[k] == arr[i]) {
                    count++; j++; k--;
                } else if (arr[j] + arr[k] < arr[i])
                    j++;
                else
                    k--;
            }
        }
        return count;
    }

    // Any better Sorting algorithm like merge/Quick sort can be used here
    void bubbleSort(int[] arr, int n) {
        for (int i=0; i<n-1; i++) {
            for (int j=0; j<n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}

//Time complexity: O(N^2)

