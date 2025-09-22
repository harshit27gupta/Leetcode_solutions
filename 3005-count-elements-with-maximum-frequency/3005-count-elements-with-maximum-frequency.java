class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums)
        map.put(i,map.getOrDefault(i,0)+1);
        int max=0;
        int ans=0;
         for (Map.Entry<Integer,Integer> entry : map.entrySet()){
             max=Math.max(max,entry.getValue());
         }  
           for (Map.Entry<Integer,Integer> entry : map.entrySet()){
             if(entry.getValue()==max)
             ans++;
         }  
         return (ans*max);
    }
}