class Solution {
    class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        HashMap<Integer,Integer> mapx=new HashMap<>();
           HashMap<Integer,Integer> mapy=new HashMap<>();
           TreeMap<Integer,Pair> map=new TreeMap<>();
           int n=mat.length;
           int m=mat[0].length;
           for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map.put(mat[i][j],new Pair(i,j));
            }
           }
           for(int i=0;i<arr.length;i++){
            Pair loc=map.get(arr[i]);
            int x=loc.x;
            int y=loc.y;
            mapx.put(x,mapx.getOrDefault(x,0)+1);
            mapy.put(y,mapy.getOrDefault(y,0)+1);
            if(mapx.get(x)==m || mapy.get(y)==n)
            return i;
           }
           return -1;
    }
}