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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //투포인터 만들고 이격시키면 뒤에서부터 가능
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode l = dummy;
        ListNode r = dummy;

        for (int i = 0; i < n; i++) {
            r = r.next;
        }

        while (r.next != null) {
            r = r.next;
            l = l.next;
        }
        l.next = l.next.next;

        return dummy.next;
    }
}