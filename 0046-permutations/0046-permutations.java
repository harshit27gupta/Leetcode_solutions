class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
       Set<Integer> st=new HashSet<>();
        List<Integer> store=new ArrayList<>();
        ways(ans,st,nums,store);
        return ans;
    }
    static void ways(List<List<Integer>> ans,Set<Integer> st,int[] nums,List<Integer> store){
if(st.size()==nums.length){
    ans.add(new ArrayList<>(store));
    return; 
}
for(int i=0;i<nums.length;i++){
    if(st.contains(i))
    continue;
    st.add(i);
    store.add(nums[i]);
    ways(ans,st,nums,store);
    st.remove(i);
    store.remove(store.size()-1);
}
    }
}