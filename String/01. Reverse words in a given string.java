/*
Company Tags:  Accolite Adobe Amazon Cisco Goldman Sachs MakeMyTrip Microsoft Paytm Samsung SAP Labs
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
*/

class Solution {
    String reverseWords(String str) {
        String[] strArr = str.split("\\.");

        StringBuilder strBuild = new StringBuilder();
        for (int i=strArr.length-1; i>=0; i--) {
            strBuild.append(strArr[i]);
            if (i != 0)
                strBuild.append(".");
        }

        return strBuild.toString();
    }
}

// TC: O(n) where n is the length of the string