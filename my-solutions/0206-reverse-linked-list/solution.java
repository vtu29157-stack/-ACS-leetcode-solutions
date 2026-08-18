class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // Store the next node
            curr.next = prev;              // Reverse the current node's pointer
            prev = curr;                   // Move prev one step forward
            curr = nextTemp;               // Move curr one step forward
        }
        
        return prev; // prev will be the new head of the reversed list
    }
}
