class Solution {
    public int[][] merge(int[][] intervals) {
      Arrays.sort(intervals,(a,b)->{
if(a[0]!=b[0])
return a[0]-b[0];
return a[1]-b[1];
      });
     List<int[]> pairs = new ArrayList<>();
int n=intervals.length;
  int prevl=intervals[0][0];
     int prevr=intervals[0][1];
for(int i=1;i<n;i++){
      int currl=intervals[i][0];
     int currr=intervals[i][1];
     if(currl>prevr){
        pairs.add(new int[]{prevl,prevr});
        prevl=currl;
        prevr=currr;
     }
     else{
        prevl=Math.min(prevl,currl);
        prevr=Math.max(prevr,currr);
     }
}
 pairs.add(new int[]{prevl, prevr});
int res[][]=new int[pairs.size()][2];
for(int i=0;i<pairs.size();i++)
res[i]=pairs.get(i);
return res;

    }
}