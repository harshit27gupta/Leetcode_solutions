class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
         TreeMap<Integer, Integer> map = new TreeMap<>();
      for(int arr[]:flowers){
        map.put(arr[0],map.getOrDefault(arr[0],0)+1);
                map.put(arr[1]+1,map.getOrDefault(arr[1]+1,0)-1);
      }
    int sum=0;
    for(int i:map.keySet()){
        sum+=map.get(i);
        map.put(i,sum);
    }
    int ans[]=new int[people.length];
    for(int i=0;i<people.length;i++){
        Integer key=map.floorKey(people[i]);
        if(key!=null)
        ans[i]=map.get(key);
    }
    return ans;
    }
}