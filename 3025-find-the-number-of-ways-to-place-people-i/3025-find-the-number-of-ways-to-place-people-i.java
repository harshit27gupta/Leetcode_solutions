class Solution {
    public int numberOfPairs(int[][] points) {
        int count=0;
        for(int i=0;i<points.length;i++)
        {
            for(int j=0;j<points.length;j++)
            {
                int x1=points[i][0],y1=points[i][1],x2=points[j][0],y2=points[j][1];
                if(i!=j&&x1<=x2&&y1>=y2)
                {
                    boolean flag=true;
                    for(int k=0;k<points.length;k++)
                    {
                        if(k!=i&&k!=j)
                        {
                            int x=points[k][0],y=points[k][1];
                            if(x>=x1&&x<=x2&&y>=y2&&y<=y1)
                            {
                                flag=false;
                                break;
                            }
                        }
                    }
                    if(flag)
                    count++;
                }
            }
        }
        return count;
    }
}