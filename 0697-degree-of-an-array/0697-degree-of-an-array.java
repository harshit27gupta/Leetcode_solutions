class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxN=50000;
          int first[]=new int[maxN];
        int last[]=new int[maxN];
        Arrays.fill(first,-1);
        int ind=0;
        for(int i:nums){
        map.put(i,map.getOrDefault(i,0)+1);
        last[i]=ind;
        if(first[i]==-1)
        first[i]=ind;
        ind++;
        }
        int ans=0;
        for(int i:map.values())
        ans=Math.max(ans,i);
        int len=Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()==ans){
                int num=entry.getKey();
                len=Math.min(len,last[num]-first[num]+1);
            }
        }
return len;
      

    }
}