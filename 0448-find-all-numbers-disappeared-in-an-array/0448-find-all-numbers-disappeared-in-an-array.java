class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<>();
        Set<Integer> val=new HashSet<>();
        for(int i:nums)
        val.add(i);
        for(int i=1;i<=n;i++){
            if(!val.contains(i))
            ans.add(i);
        }
        return ans;
    }
}