/*
Company Tags: Amazon Microsoft
Practice Portal:
Pepcoding: https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/hashmap-and-heaps/number-of-employees-under-every-manager-official/ojquestion#
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String ceo = "";
    
        HashMap<String, String> whoReportWho = new HashMap<>();
        while (n != 0) {
            String employee = scn.next();
            String manager = scn.next();
        
            if (employee.equals(manager)) {
                ceo = manager;
            } else {
                whoReportWho.put(employee, manager);   
            }
            n--;
        }
    
        HashMap<String, HashSet<String>> managementTree = new HashMap<String, HashSet<String>>();
    
        for (String currEmp : whoReportWho.keySet()) {
            String manager = whoReportWho.get(currEmp);
            if (managementTree.containsKey(manager)) {
                HashSet<String> employee = managementTree.get(manager);
                employee.add(currEmp);
                managementTree.put(manager, employee);
            } else {
                HashSet<String> employee = new HashSet<String>();
                employee.add(currEmp);
                managementTree.put(manager, employee);
            }
        }
    
        HashMap<String, Integer> employeeCount = new HashMap<String, Integer>();
        countNumberOfEmployee(managementTree, ceo, employeeCount);
        
        for (String employee : employeeCount.keySet()) {
            System.out.println(employee + " " + employeeCount.get(employee));
        }
    }

    public static int countNumberOfEmployee(HashMap<String, HashSet<String>> managementTree, 
                                            String manager, HashMap<String, Integer> employeeCount) {
        if (managementTree.containsKey(manager) == false) {
            employeeCount.put(manager, 0);
            return 1;
        }
        
        int size = 0;
        
        for (String employee : managementTree.get(manager)) {
            int count = countNumberOfEmployee(managementTree, employee, employeeCount);
            size += count;
        }
        
        employeeCount.put(manager, size);
        return size + 1;
    }
}

/*
Time Complexity: O(n) 
Space Complexity: O(n)
*/
