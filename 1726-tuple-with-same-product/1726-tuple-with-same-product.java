class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                map.put(nums[i]*nums[j],map.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        int ans=0;
        for(int i:map.values())
           if(i>=2)
           { 
           ans+=(i*(i-1))/2;
           }
           return ans*8;

    }
}