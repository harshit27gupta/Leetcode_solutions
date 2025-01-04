class Solution {
    public int maximumBeauty(int[] nums, int k) {
      TreeMap<Integer, Integer> map = new TreeMap<>();
      for(int i:nums){
        map.put(i-k,map.getOrDefault(i-k,0)+1);
                map.put(i+k+1,map.getOrDefault(i+k,0)-1);
      }
      int sum=0;
      int ans=0;
      for(int i:map.values()){
sum+=i;
ans=Math.max(ans,sum);
      }
      return ans;
    }
}