/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        // Loop until both pointers meet. 
        // If they don't intersect, they will both reach null at the same time at the end of their second pass.
        while (a != b) {
            // If pointer 'a' reaches the end of list A, redirect it to the head of list B.
            a = (a == null) ? headB : a.next;
            
            // If pointer 'b' reaches the end of list B, redirect it to the head of list A.
            b = (b == null) ? headA : b.next;
        }
        
        return a;
    }
}
