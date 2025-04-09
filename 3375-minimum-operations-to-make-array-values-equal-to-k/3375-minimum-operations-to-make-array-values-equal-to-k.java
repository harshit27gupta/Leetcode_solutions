class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> st=new HashSet<>();
        for(int i:nums)
        st.add(i);
        if(nums[0]<k)
        return -1;
        if(nums[0]==k)
        return st.size()-1;
        return st.size();
    }
}