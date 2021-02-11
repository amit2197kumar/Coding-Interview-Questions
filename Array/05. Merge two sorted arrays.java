/*
Company Tags:   Amdocs Brocade Goldman Sachs Juniper Networks Linkedin Microsoft Quikr Snapdeal Synopsys Zoho
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
*/

class MergeSort
{
    public static void merge(int arr1[], int arr2[], int n, int m)
    {
        int[] arr3 = new int[n+m];

        int i, j, k;
        i = j = k = 0;

        while (i<n && j<m) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }

        while (i<n) {
            arr3[k++] = arr1[i++];
        }

        while (j<m) {
            arr3[k++] = arr2[j++];
        }

        k=0;

        for (i=0; i<n; i++) {
            arr1[i] = arr3[k++];
        }

        for (j=0; j<m; j++) {
            arr2[j] = arr3[k++];
        }
    }
}

/*
Time Complexity: O(n + m)
Space Complexity: O(n + m)
*/

/******************************************** WITHOUT EXTRA SPACE *****************************************************/
/**********************************************************************************************************************/

/*
Iterate over array1
compare each element of arr1 with 0th element of arr2 till -> element of arr1 > 0th element of arr2
Swap the elements of arr1 and arr2 for case : element of arr1 > 0th element of arr2
Do insertionSort on arr2 to make it sorted again.
perform above steps for all elements of arr1
*/

class MergeSort
{
    public static void merge(int arr1[], int arr2[], int n, int m)  {
        int i, j;
        i = j = 0;

        while (i<n) {
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;

                insertionSort(arr2, m);
            } else {
                i++;
            }
        }
        insertionSort(arr2, m);
    }

    public static void insertionSort(int arr[], int m) {
        int value = arr[0];
        int i;
        for (i=1; i<m; i++) {
            if (arr[i] < value)
                arr[i-1] = arr[i];
            else
                break;
        }
        arr[i-1] = value;
    }
}

/*
Time Complexity: The worst case time complexity of code/algorithm is O(m*n). The worst case occurs when all elements of ar1[] are greater than all elements of ar2[].
Auxiliary Space: O(1)
*/