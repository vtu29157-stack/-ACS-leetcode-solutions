import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resIndex = 0;
        
        // Deque stores indices, keeping the values in monotonic decreasing order
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // Remove indices that are out of the current sliding window
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
                dq.pollFirst();
            }
            
            // Remove indices of smaller elements as they are useless
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            // Add the current element's index to the deque
            dq.offerLast(i);
            
            // The first element in deque is the largest element of the window
            if (i >= k - 1) {
                result[resIndex++] = nums[dq.peekFirst()];
            }
        }
        
        return result;
    }
}
