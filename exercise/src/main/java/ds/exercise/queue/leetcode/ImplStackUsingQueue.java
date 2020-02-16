package ds.exercise.queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Approach 1: push O(1) pop O(n)
 * using two queues, q1 just enqueue data, while popping off data, traverse the last data and return
 * <p>
 * Approach 2: push O(n) pop O(1)
 * using two queues, q1 always keeps the order of stack, q2 just store data and enqueue all data from q1 till q1 is empty, then swap q1 and q2
 * <p>
 * Approach 3: push O(1) pop O(1)
 * using 1 queue, when pushing data, enqueue the data before newly pushed, the first one will always the newly pushed data
 */
public class ImplStackUsingQueue {
    private Queue<Integer> q1, q2;

    /**
     * Initialize your data structure here.
     */
    public ImplStackUsingQueue() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        q1.offer(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.offer(q1.poll());
            sz--;
        }
        /* this is the approach 2
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }*/
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return q1.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty();
    }
}
