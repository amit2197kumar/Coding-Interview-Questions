/*
Company Tags:   Google Infosys Codenation Amazon Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
*/

public static int findPages(int[] arr, int n, int m) {
    if (n < m) {
        return - 1;
    }

    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i];
    }

    int start = 0;
    int end = sum;

    int result = Integer.MAX_VALUE;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (isPossible(arr, n, m, mid)) {
            result = Math.min(result, mid);
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }

    return result;
}

public static boolean isPossible(int[] arr, int n, int m, int currMin) {
    int stud = 1;
    int currSum = 0;

    for (int i = 0; i < n; i++) {

        if (arr[i] > currMin) {
            return false;
        }

        if (currSum + arr[i] > currMin) {
            stud++;
            currSum = arr[i];

            if (stud > m) {
                return false;
            }
        } else {
            currSum += arr[i];
        }
    }

    return true;
}

// Time complexity: O(nlogn)