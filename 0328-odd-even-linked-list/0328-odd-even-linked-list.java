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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);

        ListNode oddTail = oddDummy;ListNode evenTail = evenDummy;
        
        ListNode temp = head;
        int index = 1;


        while(temp != null){
            if(index % 2 != 0){
                oddTail.next = temp;
                oddTail = oddTail.next;
            }else{
                evenTail.next = temp;
                evenTail = evenTail.next;
            }

            index++;
            temp = temp.next;
        }

        oddTail.next = evenDummy.next;
        evenTail.next = null;

        return oddDummy.next;
    }
}