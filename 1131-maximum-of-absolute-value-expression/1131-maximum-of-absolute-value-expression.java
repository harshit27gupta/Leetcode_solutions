class Solution {
	public int maxAbsValExpr(int[] arr1, int[] arr2) {
		int maxF1 = Integer.MIN_VALUE, minF1 = Integer.MAX_VALUE;
        int maxF2 = Integer.MIN_VALUE, minF2 = Integer.MAX_VALUE;
        int maxF3 = Integer.MIN_VALUE, minF3 = Integer.MAX_VALUE;
        int maxF4 = Integer.MIN_VALUE, minF4 = Integer.MAX_VALUE;

        for (int i = 0; i < arr1.length; i++) {
            int f1 = arr1[i] + arr2[i] + i;
            int f2 = arr1[i] + arr2[i] - i;
            int f3 = arr1[i] - arr2[i] + i;
            int f4 = arr1[i] - arr2[i] - i;

            maxF1 = Math.max(maxF1, f1);
            minF1 = Math.min(minF1, f1);

            maxF2 = Math.max(maxF2, f2);
            minF2 = Math.min(minF2, f2);

            maxF3 = Math.max(maxF3, f3);
            minF3 = Math.min(minF3, f3);

            maxF4 = Math.max(maxF4, f4);
            minF4 = Math.min(minF4, f4);
        }
        return Math.max(Math.max(maxF1 - minF1, maxF2 - minF2), Math.max(maxF3 - minF3, maxF4 - minF4));    
	}
}