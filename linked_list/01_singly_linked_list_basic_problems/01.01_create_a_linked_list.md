# Create A Linked List

**Problem Link:** [Introduction To Linked List](https://www.naukri.com/code360/problems/introduction-to-linked-list_8144737)

## Iterative Solution

```java
public class Solution {
    public static Node constructLL(int []arr) {
        if (arr == null || arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node currNode = head;

        for (int i=1; i<arr.length; i++) {
            Node newNode = new Node(arr[i]);
            currNode.next = newNode;
            currNode = newNode;
        }
        return head;
    }
}
```
Time Complexity: `O(n)`
- The time complexity of the given code is O(n), where n is the length of the input array arr. This is because the code iterates through the entire array once in the for loop to construct the linked list.

Space Complexity: `O(n)`
- The space complexity is also O(n), where n is the length of the input array arr. This is because the code creates a new node for each element in the array, resulting in n nodes in the linked list. 

## Recursive Solution

```java
public class Solution {
    public static Node constructLL(int []arr) {
        if (arr.length == 0) return null;

        Node dummy = new Node(0);
        Node head = dummy;

        for (int i=0; i<arr.length; i++) {
            Node node = new Node(arr[i]);
            dummy.next = node;
            dummy = dummy.next;
        }

        return head.next;
    }
}
```
Time Complexity: `O(n)`
- The time complexity of the given code is O(n), where n is the length of the input array arr. This is because the code iterates through the entire array once in the for loop to construct the linked list.

Space Complexity: `O(n)`
- The space complexity is also O(n), where n is the length of the input array arr. This is because the code creates a new node for each element in the array, resulting in n nodes in the linked list. 
