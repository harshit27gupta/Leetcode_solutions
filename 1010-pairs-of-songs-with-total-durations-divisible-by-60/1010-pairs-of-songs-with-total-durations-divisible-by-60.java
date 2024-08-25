class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        for(int i=0;i<time.length;i++)
        time[i]=time[i]%60;
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for(int i=0;i<time.length;i++){
            int val=time[i];
            if(val==0 && map.containsKey(0))
            ans+=map.get(0);
            if(map.containsKey(60-val))
            ans+=map.get(60-val);
            map.put(val,map.getOrDefault(val,0)+1);
        }
        return ans;
    }
}