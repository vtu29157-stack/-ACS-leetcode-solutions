class Solution {
    public int[] finalPrices(int[] prices) {
        int[] answer = prices.clone();
        // Stack stores the indices of items waiting for a discount
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // If the current price is less than or equal to the price of the item 
            // at the index stored at the top of the stack, apply the discount.
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                answer[stack.pop()] -= prices[i];
            }
            stack.push(i);
        }
        
        return answer;
    }
}
