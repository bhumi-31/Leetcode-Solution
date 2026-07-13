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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode curr = dummy;

        int carry = 0;

        while(temp1 != null && temp2 != null){
            int sum = temp1.val + temp2.val + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum/10;
            temp1 = temp1.next;
            temp2 = temp2.next;
            curr = curr.next;
        }

        while(temp1 != null){
            int sum = temp1.val + 0 + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp1 = temp1.next;
            curr = curr.next;
        }

         while(temp2 != null){
            int sum = 0 + temp2.val  + carry;
            curr.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp2 = temp2.next;
            curr = curr.next;
        }

        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}