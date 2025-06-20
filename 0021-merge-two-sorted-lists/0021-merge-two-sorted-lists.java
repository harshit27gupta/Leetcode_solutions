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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      ListNode prev=new ListNode(-1);
      ListNode dummy=prev;
      while(list1!=null && list2!=null){
        if(list1.val<=list2.val){
            prev.next=list1;
            list1=list1.next;
        }
        else{
        prev.next=list2;
        list2=list2.next;
        }
           prev=prev.next;
      }
        while(list1!=null){
            prev.next=list1;
            list1=list1.next;
               prev=prev.next;
      }
        while(list2!=null){
        prev.next=list2;
        list2=list2.next;
           prev=prev.next;
      }
return dummy.next;

    }
}