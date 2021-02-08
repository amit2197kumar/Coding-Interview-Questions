/*
Company Tags:  Adobe Amazon Goldman Sachs Grofers Hike HSBC Ola Cabs Qualcomm Samsung SAP Labs Target Corporation VMWare
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/quick-sort/1
*/

class QuickSort
{
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high) {
            int point = partition(arr, low, high);
            quickSort(arr, low, point-1);
            quickSort(arr, point+1, high);
        }
    }

    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int curr = low-1;

        for (int i=low; i<high; i++) {
            if (arr[i] <= pivot) {
                curr++;

                int temp = arr[i];
                arr[i] = arr[curr];
                arr[curr] = temp;
            }
        }

        int temp = arr[high];
        arr[high] = arr[curr + 1];
        arr[curr + 1] = temp;

        return curr + 1;
    }
}

/*
Worst Case: The worst case occurs when the partition process always picks greatest or smallest element as pivot. The solution of above recurrence is \theta(n2)
Best Case: The best case occurs when the partition process always picks the middle element as pivot. The solution of above recurrence is \theta(nLogn)
Average Case: Solution of above recurrence is also O(nLogn)

https://www.geeksforgeeks.org/quick-sort/
*/