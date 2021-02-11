/*
Company Tags:  Amazon
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/interview-questions/
*/

public class Solution {
    public int bulbs(int[] arr) {
        int n = arr.length;

        int count = 0;
        for (int i=0; i<n; i++) {
            if (arr[i] == 0) {
                count++;
                arr[i] = 1;
                for (int j=i+1; j<n; j++) {
                    if (arr[j] == 1)
                        arr[j] = 0;
                    else
                        arr[j] = 1;
                }
            }
        }

        return count;
    }
}

/*
Time Limit Exceeded
Time Complexity: O(n^2)
Space Complexity: O(1)
*/

/**********************************************************************************************************************/
/**********************************************************************************************************************/

public class Solution {
    public int bulbs(int[] arr) {
        int n = arr.length;

        int count = 0;
        for (int i=0; i<n; i++) {

            // If till now switch is flipperd ODD number of times then bulb status needed to be flipped too
            if (count%2 != 0) {
                arr[i] = (arr[i] == 0 ? 1:0);
            }

            if (arr[i] == 0)
                count++;
        }

        return count;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
*/