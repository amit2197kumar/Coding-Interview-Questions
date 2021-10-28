/*
Company Tags:  
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/group-shifted-string-official/ojquestion
*/

import java.util.*;

public class Main {
    
    public static String getKey(String str) {
        String key = "";
        for (int i=1; i<str.length(); i++) {
            char prev = str.charAt(i-1);
            char curr = str.charAt(i);
            
            int diff = curr - prev;
            
            if (diff < 0) {
                diff += 26; // Think why we need to do this !! (Make circular)
            }
            
            key += diff + "#";
        }
        
        key += "."; // Think why we need to do this !! (single charecter)
        return key;
    }

	public static ArrayList<ArrayList<String>> groupShiftedStrings(String[] strs) {
		ArrayList<ArrayList<String>> listOfLists = new ArrayList<>();
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		
		for (String str : strs) {
		    String key = getKey(str);
		    if (map.containsKey(key)) {
		        ArrayList<String> list = map.get(key);
		        list.add(str);
		        map.put(key, list);
		    } else {
		        ArrayList<String> list = new ArrayList<>();
		        list.add(str);
		        map.put(key, list);
		    }
		}
		
		for (ArrayList<String> list : map.values()) {
		    listOfLists.add(list);
		}

		return listOfLists;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		ArrayList<ArrayList<String>> shiftedGroup = groupShiftedStrings(arr);
		for (ArrayList<String> lst : shiftedGroup) {
			Collections.sort(lst);
		}
		shiftedGroup.sort(new ListComparator());
		display(shiftedGroup);
	}

	// it is used to make the result unique
	static class ListComparator implements Comparator<List<String>> {
		@Override
		public int compare(List<String> l1, List<String> l2) {
			if (l1.size() != l2.size()) {
				return l2.size() - l1.size();
			}

			String l1str = l1.get(0);
			String l2str = l2.get(0);
			return l1str.compareTo(l2str);

		}
	}

	public static void display(ArrayList<ArrayList<String>> list) {
		for (int i = 0; i < list.size(); i++) {
			ArrayList<String> currList = list.get(i);
			for (int j = 0; j < currList.size(); j++) {
				System.out.print(currList.get(j) + " ");
			}
			System.out.println();
		}
	}

}
