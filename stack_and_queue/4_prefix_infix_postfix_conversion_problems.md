# Prefix, Infix & Postfix Problems

### 1. [Infix to Postfix](https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1)
```java
class Solution {
    public static String infixToPostfix(String exp) {
        Stack<Character> stack = new Stack<>();
        String postFix = "";
        
        for (int i=0; i<exp.length(); i++) {
            Character curr = exp.charAt(i);
            
            if ((curr>='A' && curr<='Z')||(curr>='a' && curr<='z')||(curr>='0' && curr<='9')) {
                postFix += curr;
            } else if (curr == '(') {
                stack.push(curr);
            } else if (curr == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postFix += stack.pop();
                }
                stack.pop();
            } else {
                if (precedence(curr)!=-1) {
                    while(!stack.isEmpty() && precedence(curr) <= precedence(stack.peek())) {
                        postFix += stack.pop();
                    }
                    stack.push(curr);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            postFix += stack.pop();
        }
        
        return postFix;
    }
    
    public static int precedence(Character ch) {
        if (ch=='^') return 3;
        else if (ch=='*' || ch=='/') return 2;
        else if (ch=='+' || ch=='-') return 1;
        else if (ch=='(' || ch==')') return 0;
        else return -1;
    }
}
//TC: O(n)
//SC: O(1)
```

### 2. [Infix to Prefix](https://www.geeksforgeeks.org/convert-infix-prefix-notation/)
![img.png](img.png)

### 3. [Prefix to Infix](https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1)
```java
class Solution {
    static String preToInfix(String preExp) {
        Stack<String> stack = new Stack<>();
        
        for (int i=preExp.length()-1; i>=0; i--) {
            Character ch = preExp.charAt(i);
            
            if ((ch>='a' && ch<='z')||(ch>='A' && (ch<='Z'))||(ch>='0' && ch<='9')) {
                stack.push(Character.toString(ch));
            } else {
                if (stack.size()<2) return null;
                String first = stack.pop();
                String second = stack.pop();
                
                String opr = "(" + first + Character.toString(ch) + second + ")";
                stack.push(opr);
            }
        }
        
        return stack.pop();
    }
    //TC: O(n)
    //SC: O()1
}
```

### 4. [Prefix to Postfix](https://www.geeksforgeeks.org/problems/prefix-to-postfix-conversion/1)
```java
class Solution {
    static String preToPost(String preExp) {
        Stack<String> stack = new Stack<>();
        
        for (int i=preExp.length()-1; i>=0; i--) {
            Character ch = preExp.charAt(i);
            
            if ((ch>='a' && ch<='z')||(ch>='A' && (ch<='Z'))||(ch>='0' && ch<='9')) {
                stack.push(Character.toString(ch));
            } else {
                if (stack.size()<2) return null;
                String first = stack.pop();
                String second = stack.pop();
                
                String opr = first + second + Character.toString(ch);
                stack.push(opr);
            }
        }
        
        return stack.pop();
    }
    //TC: O(n)
    //SC: O()1
}
```

### 5. [Postfix to Prefix](https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion/1)
```java
class Solution {
    static String postToPre(String postExp) {
        Stack<String> stack = new Stack<>();
        
        for (int i=0; i<postExp.length(); i++) {
            Character ch = postExp.charAt(i);
            
            if ((ch>='a' && ch<='z')||(ch>='A' && (ch<='Z'))||(ch>='0' && ch<='9')) {
                stack.push(Character.toString(ch));
            } else {
                if (stack.size()<2) return null;
                String first = stack.pop();
                String second = stack.pop();
                
                String opr = Character.toString(ch) + second + first;
                stack.push(opr);
            }
        }
        
        return stack.pop();
    }
    //TC: O(n)
    //SC: O()1
}
```

### 6. [Postfix to Infix](https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1)
```java
class Solution {
    static String postToInfix(String postExp) {
        Stack<String> stack = new Stack<>();
        
        for (int i=0; i<postExp.length(); i++) {
            Character ch = postExp.charAt(i);
            
            if ((ch>='a' && ch<='z')||(ch>='A' && (ch<='Z'))||(ch>='0' && ch<='9')) {
                stack.push(Character.toString(ch));
            } else {
                if (stack.size()<2) return null;
                String first = stack.pop();
                String second = stack.pop();
                
                String opr =  "(" + second + Character.toString(ch) + first + ")";
                stack.push(opr);
            }
        }
        
        return stack.pop();
    }
    //TC: O(n)
    //SC: O()1
}
```