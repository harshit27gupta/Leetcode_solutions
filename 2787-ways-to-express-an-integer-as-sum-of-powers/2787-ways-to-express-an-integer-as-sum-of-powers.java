class Solution {
    public int numberOfWays(int n, int x) {
		long[][] cummulative = new long[n + 1][n + 1];
		long[] total = new long[n + 1];
		total[0] = 1;
		for (int i = 1; i <= n; i++) {
			int pj=0;
			for (int j = 1; (pj = new Double(Math.pow(j, x)).intValue()) <i ; j++) {
				if(i-pj>pj) {
					total[i] = total[i]  + total[i - pj] - cummulative[i - pj][pj];
				}		
				cummulative[i][pj]= total[i] ; 
			}
			if(pj==i) {
				total[i] ++;
				cummulative[i][i]=total[i] ;  
			}
		}
		return new Long(total[n]%1000000007).intValue();
    }
}
