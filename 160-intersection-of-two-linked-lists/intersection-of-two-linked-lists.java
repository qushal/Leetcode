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
        int size1= 0;
        int size2= 0;
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1 != null){
            temp1 = temp1.next;
            size1++;
        }
        while(temp2 != null){
            temp2 = temp2.next;
            size2++;
        }
        while(size1 > size2){
            headA = headA.next;
            size1--;
        }
        while(size2>size1){
            headB = headB.next;
            size2--;
        }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }
}