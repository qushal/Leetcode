# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        if head == None or head.next == None:
            return True
        stack = []
        slow = fast = head

        while fast and fast.next:
            stack.append(slow.val)
            slow = slow.next
            fast = fast.next.next
        print(stack)
        if fast: slow = slow.next

        while slow:
            if stack.pop() != slow.val:
                return False
            slow = slow.next
        print(stack)
        return True
            

        