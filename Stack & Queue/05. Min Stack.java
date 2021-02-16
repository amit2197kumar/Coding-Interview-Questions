/*
Company Tags:   Adobe Amazon FactSet Goldman Sachs Intuit Linkedin MakeMyTrip Paytm SAP Labs VMWare Walmart Microsoft
Practice Portal:
Geeksforgeeks: https://practice.geeksforgeeks.org/problems/special-stack/1
LeetCode: https://leetcode.com/problems/min-stack/
*/

// Using extra space(extra Stack)

class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        int min;
        if (!minStack.empty()) {
            min = x < minStack.peek() ? x : minStack.peek();
        } else {
            min = x;
        }
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

// Better SOL.

class MinStack {

    Stack<Integer> stack = new Stack<Integer>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}