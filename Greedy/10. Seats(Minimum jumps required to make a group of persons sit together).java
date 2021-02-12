/*
Company Tags:   Accolite Amazon D-E-Shaw Microsoft Nagarro
Practice Portal:
InterviewBit: https://www.interviewbit.com/problems/seats/
*/

/*
Its will to difficult to visualise, better watch and read below:
1. https://youtu.be/SK2ypa7poKg
2. https://www.geeksforgeeks.org/minimum-jumps-required-to-make-a-group-of-persons-sit-together/
 */

public class Solution {
    public int seats(String arr) {
        ArrayList<Integer> position = new ArrayList<>();

        for (int i=0; i<arr.length(); i++) {
            if (arr.charAt(i) == 'x')
                position.add(i);
        }

        int mid = position.size()/2;
        int ans = 0;

        int start, end;
        for (int i=0; i<position.size(); i++) {
            start = position.get(i);
            end =  position.get(mid)-mid + i;
            ans = (ans + Math.abs(end-start))%10000003;
        }

        return ans%10000003;
    }
}

/*
Time Complexity: O(n).
Auxiliary Space: O(1).
*/