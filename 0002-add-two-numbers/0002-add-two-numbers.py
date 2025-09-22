# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0
        iterator = ListNode()
        ans = iterator
        while (l1 or l2) or carry != 0: #l1 l2둘중 하나라도 null이 아니면 안끝남. carry도 0아니면 안끝남
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0

            sum = val1 + val2 + carry
            valSum = sum % 10
            carry = sum // 10

            #print(f"val1={val1},val2={val2}, sum={sum}, valSum={valSum}, carry={carry}")
            node = ListNode(valSum)
            iterator.next = node
            iterator = node

            l1 = l1.next if l1 and l1.next else None
            l2 = l2.next if l2 and l2.next else None
        
        return ans.next