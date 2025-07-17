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
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        //ListNode prev = null;

        //가운데 찾기
        while (fast != null && fast.next != null) {
            //prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        //두개로 분리해서 역순이랑 기존의 순서지만 반잘린거 만들기
        ListNode secondHalf = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (secondHalf != null) {
            ListNode tmp = secondHalf.next;
            secondHalf.next = prev; //실제로 뒤집기
            prev = secondHalf;
            secondHalf = tmp; //계속 순회
        }

        //순회하면서 잘 합치기
        ListNode firstHalf = head; //current는 순방향 반, reversed는 역방향 반
        secondHalf = prev;
        while (firstHalf != null && secondHalf != null ) {
            ListNode tmp1 = firstHalf.next;
            ListNode tmp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = tmp1;

            firstHalf = tmp1;
            secondHalf = tmp2;
        }
    }
}
/**
리스트 순회하기
일단 마지막이ㄹ아 연결하려면
순방향 리스트 하나랑
역방향 리스트 하나를 만들어서

그거를 같이 순회해
그러면서 각 리스트의 첫번째끼리 연결
그리고 그거랑 또 각리스트의 두번쨰ㅣ낄 연결 반복

1. 역방향만들기
    새로 만들어야하니까
    기존 거 순회하면서 새로운 listnode를 생성하면서 해야함.
        기존거 순회하면하면서 그냥 새로만들어 나가면 될듯?
2. 같이 순회하기

지금 안되는 부분이
새로 만들어놓은 리스트랑 기존의 리스트를 조작해서
head(기존 체제)로 리턴(실제로 하지는 않음) 조작해야 하는데 그것이 헷갈림.
 */