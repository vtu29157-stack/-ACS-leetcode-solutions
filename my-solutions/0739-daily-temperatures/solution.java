import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        // The stack will store the indices of the temperatures
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            // While the stack is not empty and the current temperature is warmer
            // than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                // Calculate the number of days waited and store in the answer array
                answer[prevDay] = i - prevDay;
            }
            // Push the current index onto the stack to find its next warmer day
            stack.push(i);
        }
        
        return answer;
    }
}
