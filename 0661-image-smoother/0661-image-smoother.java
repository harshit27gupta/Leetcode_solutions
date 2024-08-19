class Solution {
    public int[][] imageSmoother(int[][] img) {
        int[][] ans = new int[img.length][img[0].length];
        int sum, count;
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                sum = img[i][j];
                count = 1;
                if ((j - 1) >= 0) {
                    sum += img[i][j - 1];
                    count++;
                }
                if ((j + 1) < img[0].length) {
                    sum += img[i][j + 1];
                    count++;
                }
                if ((i - 1) >= 0) {
                    sum += img[i - 1][j];
                    count++;
                    if ((j - 1) >= 0) {
                        sum += img[i - 1][j - 1];
                        count++;
                    }
                    if ((j + 1) < img[0].length) {
                        sum += img[i - 1][j + 1];
                        count++;
                    }
                }
                if ((i + 1) < img.length) {
                    sum += img[i + 1][j];
                    count++;
                    if ((j - 1) >= 0) {
                        sum += img[i + 1][j - 1];
                        count++;
                    }
                    if ((j + 1) < img[0].length) {
                        sum += img[i + 1][j + 1];
                        count++;
                    }
                }
                ans[i][j] = sum / count;
            }
        }
        return ans;
    }
}