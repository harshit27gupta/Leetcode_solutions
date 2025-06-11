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
    static int cnt(ListNode head){
        int cnt=0;
        while(head!=null){
            cnt++;
            head=head.next;
        }
        return cnt;
    }
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null)
        return head;
        if(head.next.next==null)
        return head.next;
        int count=cnt(head);
        count/=2;
ListNode cc=head;
while(count>0){
    cc=cc.next;
    count--;
}
return cc;
        
    }
}