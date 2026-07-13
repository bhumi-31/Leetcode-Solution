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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode front = null;
        ListNode temp1 = head;
        ListNode temp2 = head;

        int cnt1 = 1;
        while (temp1 != null) {
            if (cnt1 == left) break;
            front = temp1;       // CHANGED
            temp1 = temp1.next;
            cnt1++;
        }

        int cnt2 = 1;
        while(temp2 != null){
            if(cnt2 == right) break;
            temp2 = temp2.next;
            cnt2++;
        }

        ListNode last = temp2.next;

        ListNode prev = last;
        ListNode curr = temp1;
        ListNode next = null;

        while(curr != last){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (front != null) {
            front.next = prev;
        } else {
            head = prev;
        }

        return head;
    }
}