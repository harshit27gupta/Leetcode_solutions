class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int arr[]:queries){
            int l=arr[0];
            int r=arr[1];
            map.put(l,map.getOrDefault(l,0)+1);
              map.put(r+1,map.getOrDefault(r+1,0)-1);
        }
        int[] delta = new int[nums.length];
    int curr = 0;
    for (int i = 0; i < nums.length; i++) {
        if (map.containsKey(i)) {
            curr += map.get(i);
        }
        delta[i] = curr;
    }
    for (int i = 0; i < nums.length; i++) {
        if (delta[i]<nums[i]) return false;
    }

    return true;
        
    }
}