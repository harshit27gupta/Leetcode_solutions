class Solution {
    public int lenLongestFibSubseq(int[] nums) {
        Set<Integer> st=new HashSet<>();
        for(int i:nums)
        st.add(i);
    int n=nums.length;
    int val=0;
    for(int i=0;i<n-2;i++){
        for(int j=i+1;j<n-1;j++){
            int ans=0;
       if(st.contains(nums[i]+nums[j])){
         ans=3;
        int prev=nums[j];
        int curr=nums[i]+nums[j];
        while(st.contains(curr+prev)){
            int tmp=curr;
            curr=curr+prev;
                prev=tmp;
ans++;
        }
       }
       val=Math.max(val,ans);

        }
    }
    return val;
    }
}