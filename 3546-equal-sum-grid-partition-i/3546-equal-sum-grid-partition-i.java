class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long sum=0;
    int n=grid.length;
    int m=grid[0].length;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            sum+=grid[i][j];
        }
    }
    if(sum%2==1)
    return false;
long tar=sum/2;
if(n>1){
      long k=0;
for(int i=0;i<n;i++){
    for(int j=0;j<m;j++)
    k+=grid[i][j];
    if(k==tar)
    return true;
}
}
if(m>1){
      long k=0;
for(int j=0;j<m;j++){
    for(int i=0;i<n;i++)
    k+=grid[i][j];
    if(k==tar)
    return true;
}
}
return false;
    }
}