class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //find nextgreater element for each num2 element
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[nums2.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[st.peek()]<nums2[i])
            ans[st.pop()]=nums2[i];
            st.push(i);
        }
        //now check for each element
        int ans1[]=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    ans1[i]=ans[j];
                    break;
                }
            }
        }
        return ans1;
    }
}