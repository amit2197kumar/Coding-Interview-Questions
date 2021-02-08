/*
Company Tags:   Amazon Boomerang Commerce Goldman Sachs Grofers Medlife Microsoft Oracle Paytm Qualcomm Snapdeal Target Corporation Wipro
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/merge-sort/1
*/

class GfG
{
    void merge(int arr[], int left, int mid, int right)
    {
        int size = right - left + 1;

        int[] tempArr = new int[size];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }

        while (j <= right) {
            tempArr[k++] = arr[j++];
        }


        for (int x=0, y=left; y<=right; x++, y++) {
            arr[y] = tempArr[x];
        }
    }
}

//Full Code: https://www.geeksforgeeks.org/merge-sort/

/*
Time Complexity: Time complexity of Merge Sort is  θ(nLogn) in all 3 cases (worst, average and best) as merge sort always divides the array into two halves and takes linear time to merge two halves.
Auxiliary Space: O(n)
Algorithmic Paradigm: Divide and Conquer
Sorting In Place: No in a typical implementation
Stable: Yes
*/