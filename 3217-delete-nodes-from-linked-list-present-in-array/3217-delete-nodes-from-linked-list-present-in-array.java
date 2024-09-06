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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> st=new HashSet<>();
        for(int i:nums)
        st.add(i);
     ArrayList<Integer> cc=new ArrayList<>();
     ListNode temp=head;
     while(temp!=null)
     {
        if(st.contains(temp.val)){
        temp=temp.next;
        }
        else{
            cc.add(temp.val);
            temp=temp.next;
        }
     }
     ListNode dummy=new ListNode(-1);
     ListNode res=dummy;
     int i=0;
     while(i<cc.size()){
        ListNode now=new ListNode(cc.get(i));
        res.next=now;
        res=res.next;
        i++;
     }
     res.next=null;
     return dummy.next;
    }
}