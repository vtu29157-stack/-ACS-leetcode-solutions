
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node initialization to handle edge cases easily (e.g., when the head changes)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: Count the total number of nodes in the linked list
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Step 2: Reverse nodes in groups of k
        ListNode pre = dummy;
        ListNode nex;
        
        while (count >= k) {
            curr = pre.next;
            nex = curr.next;
            
            // Reverse k nodes
            for (int i = 1; i < k; i++) {
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            // Move pre pointer to the end of the reversed group
            pre = curr;
            // Decrease the count of nodes left to process
            count -= k;
        }

        return dummy.next;
    }
}
