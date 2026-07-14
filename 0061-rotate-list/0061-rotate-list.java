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
    public int len(ListNode head){
        ListNode temp = head;
        int len = 0;

        while(temp != null){
            len++;
            temp = temp.next;
        }

        return len;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }

        int n = len(head);
        k = k % n;
        if(k == 0) return head;

        ListNode curr = head;
        int cnt = 0;
        while(curr != null){
            if(cnt == n - k - 1) break;
            curr = curr.next;
            cnt++;
        }

        ListNode next = curr.next;
        curr.next = null;

        ListNode temp = next;

        while(temp.next != null){
            temp = temp.next;
        }

        if(temp != null){
            temp.next = head;
        }

        return next;
    }
}