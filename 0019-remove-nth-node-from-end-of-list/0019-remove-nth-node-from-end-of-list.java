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
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode left = dummy;
        ListNode right = dummy;

        //n만큼 띄워놓기
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        //끝까지 이동(맨끝)
        //1->2->3에서 2를 지운다면
        //l은 1을 r은 3에 위치중
        while (right.next != null) {
            left =left.next;
            right = right.next;
        }
        
        //이제 지우기
        left.next = left.next.next;

        return dummy.next;
    }
}