class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Using an array as a stack for optimal performance
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int ast : asteroids) {
            boolean destroyed = false;
            
            // Check for collisions: moving right (stack top > 0) and moving left (current ast < 0)
            while (top >= 0 && stack[top] > 0 && ast < 0) {
                if (stack[top] < -ast) {
                    // Top asteroid is smaller, it explodes. Keep checking the current one.
                    top--;
                    continue;
                } else if (stack[top] == -ast) {
                    // Both are the same size and explode.
                    top--;
                }
                // If stack[top] > -ast, the current asteroid explodes.
                destroyed = true;
                break;
            }
            
            if (!destroyed) {
                stack[++top] = ast;
            }
        }

        // Copy the remaining asteroids from the stack to the result array
        int[] result = new int[top + 1];
        System.arraycopy(stack, 0, result, 0, top + 1);
        return result;
    }
}
