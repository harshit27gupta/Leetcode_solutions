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
      ListNode dummy=new ListNode(-1);
      ListNode cc=dummy;
      while(list1!=null && list2!=null){
        if(list1.val<=list2.val){
            dummy.next=new ListNode(list1.val);
            list1=list1.next;
            dummy=dummy.next;
        }
        else{
            dummy.next=new ListNode(list2.val);
            list2=list2.next;
            dummy=dummy.next;
        }
      }
       while(list1!=null){
            dummy.next=new ListNode(list1.val);
            list1=list1.next;
            dummy=dummy.next;
        }
       while(list2!=null){
            dummy.next=new ListNode(list2.val);
            list2=list2.next;
            dummy=dummy.next;
      }
return cc.next;
        
    }
}