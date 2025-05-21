class Solution {
  public int countDays(int days, int[][] meetings) {
	Arrays.sort(meetings, (int[] a, int[] b) -> {
		if(a[0] == b[0]) return a[1]-b[1];
		return a[0]-b[0];
	});

	int res = 0, e = 0, n=meetings.length;
	for(int i=0; i<n; i++){
		if(meetings[i][0] > e) {
			res += (meetings[i][0]-e-1);
		}
		e = Math.max(meetings[i][1], e);
	}
	res += days-e;
	return res;
}
}