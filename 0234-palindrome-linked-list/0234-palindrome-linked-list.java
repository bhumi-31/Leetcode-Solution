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
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public ListNode findRev(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }

        ListNode mid = findMid(head);
        ListNode second = mid;


        ListNode rev = findRev(second);


        ListNode left = head;
        ListNode right = rev;

        while(left != null && right != null){
            if(left.val != right.val){
                return false;
            }

            left = left.next;
            right = right.next;
        }

        return true;
    }
}