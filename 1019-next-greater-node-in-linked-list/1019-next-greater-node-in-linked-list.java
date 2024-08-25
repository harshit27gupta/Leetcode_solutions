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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> num=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        ListNode temp=head;
     while(temp!=null){
        num.add(temp.val);
        temp=temp.next;
     }
     int ans[]=new int[num.size()];
     for(int i=0;i<ans.length;i++){
        while(!st.isEmpty() && num.get(st.peek())<num.get(i)){
            ans[st.pop()]=num.get(i);
        }
        st.push(i);
     }
     return ans;
    }
}