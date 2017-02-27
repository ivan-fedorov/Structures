package com.queue;

import java.util.Stack;

class MyQueue {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> reverseStack = new Stack<>();

    void enqueue(int value) {
        while (!reverseStack.isEmpty()) {
            stack.push(reverseStack.pop());
        }
        stack.push(value);
    }

    int peek() {
        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        return reverseStack.peek();
    }

    int dequeue() {
        while (!stack.isEmpty()) {
            reverseStack.push(stack.pop());
        }
        return reverseStack.pop();
    }
}


