package ds.exercise.stack.leetcode;

import java.util.Stack;

/**
 * push(): first push all data from stack2 to stack1, and push new data to stack1, then push back all data to stack2, O(n)
 * pop(): directly pop data off from stack2, O(1)
 * <p>
 * https://leetcode.com/problems/implement-queue-using-stacks
 */
public class ImplQueueUsingStacks2 {
    Stack<Integer> s1, s2;

    /**
     * Initialize your data structure here.
     */
    public ImplQueueUsingStacks2() {
        s1 = new Stack();
        s2 = new Stack();
    }

    /**
     * Push element x to the back of queue.
     * <p>
     * O(n)
     */
    public void push(int x) {
        while (!s2.empty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
        while (!s1.empty()) {
            s2.push(s1.pop());
        }
    }

    /**
     * Removes the element from in front of queue and returns that element.
     * <p>
     * O(1)
     */
    public int pop() {
        return s2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        return s2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return s2.empty();
    }
}