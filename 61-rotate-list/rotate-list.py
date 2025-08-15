# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head
        temp = head
        size = 1
        while temp.next:
            size += 1
            temp = temp.next
        prev = temp

        k = k % size
        if k == 0: return head

        point = size - k - 1
        last = head
        while point > 0:
            last = last.next
            point -= 1

        temp = last.next
        last.next = None
        prev.next = head

        return temp
