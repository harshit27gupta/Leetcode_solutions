class Solution {
    public long countBadPairs(int[] nums) {
    int n=nums.length;
    long pairs=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<n;i++){
        pairs+=(i-map.getOrDefault(nums[i]-i,0));
        map.put(nums[i]-i,map.getOrDefault(nums[i]-i,0)+1);
    }
    return pairs;
    }
}