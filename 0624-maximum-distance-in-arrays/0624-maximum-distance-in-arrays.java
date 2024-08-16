class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int mini = arrays.get(0).get(0);
        int maxi = arrays.get(0).get(arrays.get(0).size() - 1);
        int max= 0;
        for(int i=1; i<arrays.size(); i++){
            int currentMin = arrays.get(i).get(0);
            int currentMax = arrays.get(i).get(arrays.get(i).size() - 1);
            max = Math.max(max, Math.abs(currentMax-mini));
            max = Math.max(max, Math.abs(maxi-currentMin));
            mini = Math.min(mini, currentMin);
            maxi = Math.max(maxi, currentMax);
        }
        return max;
    }
}