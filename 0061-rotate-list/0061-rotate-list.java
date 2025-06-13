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
    static int count(ListNode temp){
        int cnt=0;
        while(temp!=null){
            cnt++;
            temp=temp.next;
        }
        return cnt;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null)
        return head;
                int count=count(head);
          int rotate=k%count;
        if(rotate==0)
        return head;
         ListNode last=head;
        ListNode join=head;
        while(join!=null){
            last=join;
            join=join.next;
        }
        join=head;
        int steps=count-rotate-1;
        ListNode dummy=head;
        while(steps>0){
            dummy=dummy.next;
            steps--;
        }
        ListNode new_Head=dummy.next;
        dummy.next=null;
        last.next=join;
        return new_Head;



    }
}