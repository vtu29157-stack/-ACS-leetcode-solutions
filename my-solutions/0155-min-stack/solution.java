import java.util.Stack;

class MinStack {
    // Stack stores arrays of size 2: {current_value, current_minimum}
    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(new int[]{value, value});
        } else {
            int currentMin = stack.peek()[1];
            stack.push(new int[]{value, Math.min(value, currentMin)});
        }
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
