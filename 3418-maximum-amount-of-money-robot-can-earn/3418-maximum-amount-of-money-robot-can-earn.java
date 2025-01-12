class Solution {
    static int  f( int[][] coins , int[][][] dp , int i , int j , int neutrals ){
        if( i==0 && j==0 ){
            if( coins[i][j] < 0 && neutrals<2 ){
                dp[i][j][neutrals] = 0 ;
            }
            else{
                dp[i][j][neutrals] = coins[i][j] ;
            }
            return dp[i][j][neutrals] ;
        }
        if( i<0 || j<0 )    
        return -(int)1e9;
        if(dp[i][j][neutrals] != -(int)1e9 )     
        return dp[i][j][neutrals];   
        int up = -(int)1e9 ;
        int left = -(int)1e9 ;  
        if(i>0){
            if( coins[i][j] < 0 && neutrals<2 ){
                up = Math.max( up , f( coins, dp, i-1, j , neutrals+1 ) );
            }
            up = Math.max( up, coins[i][j] + f( coins, dp, i-1, j , neutrals ) );

        }
        if(j>0){
            if( coins[i][j] < 0 && neutrals<2 ){
                left = Math.max( left , f( coins, dp, i, j-1, neutrals+1 ) ) ;
            }            
            left = Math.max( left , coins[i][j] + f( coins, dp, i, j-1, neutrals ) );
        }      
        return dp[i][j][neutrals] = Math.max(up,left) ;
    }
    public int maximumAmount(int[][] coins) {
        int  m = coins.length ;
        int  n = coins[0].length ;
        int[][][]  dp = new int[m][n][3] ;
        for(int i=0 ; i<m ; i++){
            for(int j=0 ; j<n ; j++){
                for(int k=0 ; k<3 ; k++){
                    dp[i][j][k] = -(int)1e9 ;
                }    
            }
        }
        f( coins , dp , m-1 , n-1 , 0 );
        return  Math.max( dp[m-1][n-1][0] , Math.max( dp[m-1][n-1][1] , dp[m-1][n-1][2] )  ) ;
    }
}