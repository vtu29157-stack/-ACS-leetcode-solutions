
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // Phase 1: Detect if there is a cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // If no cycle was found, return null
        if (!hasCycle) {
            return null;
        }

        // Phase 2: Find the starting node of the cycle
        // Reset the slow pointer to the head of the list
        slow = head;
        
        // Move both pointers at the same speed until they meet
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // The meeting point is the start of the cycle
        return slow;
    }
}
