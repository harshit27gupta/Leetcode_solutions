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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set=new HashSet<>();
        ListNode itr=head;
        int num_comp=0,connected=0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        while(itr!=null){
            if(set.contains(itr.val)){
                connected++;
            }
            else{
                if(connected>0){
                    num_comp+=1;
                    connected=0;
                }
                
            }
            itr=itr.next;
            
        }
        if(connected>0)
        return num_comp+1;
        return num_comp;
    }
}