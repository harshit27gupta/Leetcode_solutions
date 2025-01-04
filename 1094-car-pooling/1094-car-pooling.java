class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
           TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int arr[]:trips){
            map.put(arr[1],map.getOrDefault(arr[1],0)+arr[0]);
                        map.put(arr[2],map.getOrDefault(arr[2],0)-arr[0]);
        }
        int sum=0;
        for(int i:map.values()){
sum+=i;
if(sum>capacity)
return false;
        }
        return true;
    }
}