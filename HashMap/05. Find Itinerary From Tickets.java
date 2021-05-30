/*
Company Tags: Microsoft
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/find-itinerary-from-tickets-official/ojquestion
*/

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);	
		}

		//write your code here

        HashMap<String, Boolean> allPlaces = new HashMap<String, Boolean>();
        for (String source : map.keySet()) {
            if (allPlaces.containsKey(source)) {
                allPlaces.put(source, false);
            } else {
                allPlaces.put(source, true);
            }
            allPlaces.put(map.get(source), false);
        }
        
        String startPoint = "";
        for (String source : allPlaces.keySet()) {
            if (allPlaces.get(source) == true) {
                startPoint = source;
                break;
            }
        }
        
        while (true) {
            if (map.containsKey(startPoint)) {
                System.out.print(startPoint + " -> ");
                startPoint = map.get(startPoint);
            } else {
                System.out.print(startPoint);
                System.out.print(".");
                break;
            }
        }
	}
}

/*
Time Complexity: O(n) 
Space Complexity: O(n)
*/
