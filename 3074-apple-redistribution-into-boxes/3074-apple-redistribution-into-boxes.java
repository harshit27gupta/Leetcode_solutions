class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum=0;
        for(int i=0;i<apple.length;i++)
            sum+=apple[i];
        Arrays.sort(capacity);
        int ans=0;
        for(int i=capacity.length-1;i>=0;i--){
            if(sum==0)
                break;
            if(sum>=capacity[i]){
                sum-=capacity[i];
                ans++;
            }
            else if(sum<capacity[i]){
                sum=0;
                ans++;
                break;
            }
                    else
                    break;
        }
            if(sum==0)
                return ans;
            return -1;
            
        
    }
}