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
        ListNode current = head;
        int length = 0;
        //길이 측정
        while (current != null) {
            current = current.next;
            length++;
            //System.out.println("length: " + length);
        }

        //만약 첫번쨰가 제거 대상일 경우
        
        
        //길이5에서 2구하라고 하면 4번째거 구하는 것.
        //그러니까 cnt는 4가 되어야 하고 5 - 2 + 1한 4
        current = head;
        int target = length - n + 1;
        if (target == 1 && length > 1) {
            head = head.next;
            return head;
        }

        int cnt = 1;
        while (current != null) {
            //System.out.println("count + 1, target:" + (cnt+1) + ", " + target);
            if (cnt + 1 == target) {
                current.next = current.next.next;
                return head;
            }
            current = current.next;
            cnt++;
        }

        return null;
    }
}