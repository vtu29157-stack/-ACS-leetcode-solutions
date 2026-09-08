import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Iterate through the string to find mismatched parentheses
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    // No matching '(', mark this ')' as invalid
                    chars[i] = '*'; 
                } else {
                    // Found a valid pair, remove the '(' index from stack
                    stack.pop(); 
                }
            }
        }
        
        // Step 2: Any indices left in the stack are unmatched '('
        while (!stack.isEmpty()) {
            chars[stack.pop()] = '*';
        }
        
        // Step 3: Build the final string ignoring the '*' characters
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (c != '*') {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
