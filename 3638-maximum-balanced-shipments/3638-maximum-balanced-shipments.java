class Solution {
    public int maxBalancedShipments(int[] weight) {
        int max=0;
        int cnt=0;
        for(int i=0;i<weight.length;i++){
            if(max>weight[i]){
                cnt++;
                max=0;
            }
            else
            max=Math.max(max,weight[i]);
        }
    
return cnt;
    }
}