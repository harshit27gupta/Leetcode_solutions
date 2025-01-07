class Solution {
    public double[] sampleStats(int[] count) {
        double[] ans = new double[5]; 
        int[] prefix = new int[256];
        prefix[0] = count[0];
        double sum = 0;
        int total = 0;
        int maxCount = 0; 
        int n = count.length;
        ans[0] = -1; 
        ans[1] = -1; 
        for (int i = 0; i < n; i++) {
            if (count[i] > 0 && ans[0] == -1) {
                ans[0] = (double) i;
            }
            if (count[i] > 0) {
                ans[1] = (double) i;
            }
            sum += (double) (i * count[i]);
            total += count[i];
            prefix[i] = total;
            if (count[i] > maxCount) {
                maxCount = count[i];
                ans[4] = (double) i;
            }
        }
        ans[2] = sum / total;
        if (total % 2 == 1) {
            int medianPos = (total + 1) / 2;
            for (int i = 0; i < n; i++) {
                if (prefix[i] >= medianPos) {
                    ans[3] = (double) i;
                    break;
                }
            }
        } else {
            int medianPos1 = total / 2;
            int medianPos2 = medianPos1 + 1;
            int median1 = -1, median2 = -1;

            for (int i = 0; i < n; i++) {
                if (prefix[i] >= medianPos1 && median1 == -1) {
                    median1 = i;
                }
                if (prefix[i] >= medianPos2) {
                    median2 = i;
                    break;
                }
            }
            ans[3] = (median1 + median2) / 2.0;
        }

        return ans;
    }
}
