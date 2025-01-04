class Solution {
    public int maximumPopulation(int[][] logs) {
          TreeMap<Integer, Integer> map = new TreeMap<>();
      for(int arr[]:logs){
        map.put(arr[0],map.getOrDefault(arr[0],0)+1);
                map.put(arr[1],map.getOrDefault(arr[1],0)-1);
      }
      int sum=0;
      int ans=0;
      int ans2=-1;
      for(int i:map.keySet()){
sum+=map.get(i);
if(sum>ans){
ans=sum;
ans2=i;
}
      }
      return ans2;
    }
}