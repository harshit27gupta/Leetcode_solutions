class Solution {
    public boolean isBoomerang(int[][] points) {
       int  val1=(points[1][1]-points[0][1])*(points[2][0]-points[1][0]);
      int val2=(points[1][0]-points[0][0])*(points[2][1]-points[1][1]);
      return val1!=val2;

    }
}