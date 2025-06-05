class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st=new HashSet<>();
        for(int i:nums)
        st.add(i);
        int ans=0;
        for(int i:st){
   int cnt=1;
   int k1=i;
   if(!st.contains(k1-1)){
    while(st.contains(k1+1)){
        k1++;
        cnt++;
    }
   }
   ans=Math.max(ans,cnt);
        }
        return ans;
    }
}