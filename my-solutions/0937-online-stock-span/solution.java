import java.util.Stack;

class StockSpanner {
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // Pop elements from the stack while the previous price is less than or equal to the current price.
        // Accumulate their spans into the current span.
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        
        // Push the current price and its calculated span onto the stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}
