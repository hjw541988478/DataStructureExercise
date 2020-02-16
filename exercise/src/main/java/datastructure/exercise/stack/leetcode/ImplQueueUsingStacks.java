package datastructure.exercise.stack.leetcode;

import java.util.Stack;

/**
 * push: always store data on stack1, O(1)
 * pop or peek: when stack2 is empty, push all on the data from stack1, and then pop() or peek(), O(1)
 * <p>
 * https://leetcode.com/problems/implement-queue-using-stacks
 */
class ImplQueueUsingStacks {
    Stack<Integer> s1, s2;

    /**
     * Initialize your data structure here.
     */
    public ImplQueueUsingStacks() {
        s1 = new Stack();
        s2 = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        s1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s2.empty() && s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */