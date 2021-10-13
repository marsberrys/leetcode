package base;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author weixun
 * @Date 2021-10-12
 */
public class MinStack {
    private Deque<Integer> itemStack;
    private Deque<Integer> minStack;

    public MinStack() {
        itemStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        itemStack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        itemStack.pop();
        minStack.pop();
    }

    public int top() {
        return itemStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
