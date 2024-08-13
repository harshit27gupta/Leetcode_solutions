class Solution {
    static int[] find(int nums[]){
        int ans[]=new int[nums.length];
        Arrays.fill(ans,-1);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                ans[st.pop()]=i;
            }
            st.push(i);
        }
        return ans;
    }
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++)
        map.put(nums2[i],i);
        int res[]=find(nums2);
        int ans[]=new int[nums1.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<nums1.length;i++){
            int idx=map.get(nums1[i]);
            if(res[idx]==-1)
            continue;
ans[i]=nums2[res[idx]];
        }
        return ans;
    }
}