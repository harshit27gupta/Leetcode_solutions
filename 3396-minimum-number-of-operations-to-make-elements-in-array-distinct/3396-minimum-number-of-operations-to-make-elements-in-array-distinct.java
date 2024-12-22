class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
       Set<Integer> st=new HashSet<>();
       int ans=n-1;
         st.add(nums[n-1]);
       for(int i=n-2;i>=0;i--){
if(st.contains(nums[i]))
break;
ans=i;
st.add(nums[i]);
       }
       return ans/3+Math.min(ans%3,1);
    }
}