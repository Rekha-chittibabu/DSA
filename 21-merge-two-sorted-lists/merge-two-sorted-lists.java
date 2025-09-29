/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1 -> 2 -> 4
        // 1 -> 3 -> 4

        ListNode l1 = list1;
        ListNode l2 = list2;
        ListNode dummy = new ListNode(-1);  // Like a placeholder head
        ListNode current = dummy;           // Pointer to build result


        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

         // Attach remaining nodes
        if (l1 != null) current.next = l1;
        else current.next = l2;

        return dummy.next; // Return head of merged list
    }
}