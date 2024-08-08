class Solution {
    public static int maxsize = 201, r;
    public static int[] stack = new int[maxsize];
    public static int[] height;

    public int maximalRectangle(char[][] matrix) {
        height = new int[matrix[0].length];
        int ans = 0;
        for(int i = 0; i <matrix.length;i++){
            for(int j=0;j<matrix[0].length; j++){
                height[j] = matrix[i][j] == '0'? 0: height[j]+1;
            }

            ans = Math.max(ans, f(height));
        }
        return ans;
    }

    public int f(int[] height){
        r = 0;
        int cur;
        int left;
        int right;
        int ans = 0;
        for(int i = 0; i < height.length; i++){
            while(r>0 && height[i]<=height[stack[r-1]]){
                cur = stack[--r];   
                right = i;
                left = r==0? -1:stack[r-1];
                ans = Math.max(ans, (right-left-1)*height[cur]);
            }
            stack[r++] = i;
        }

        while(r>0){
            cur = stack[--r];   
            right = height.length;
            left = r==0? -1:stack[r-1];
            ans = Math.max(ans, (right-left-1)*height[cur]);
        }


        return ans;
    }
}