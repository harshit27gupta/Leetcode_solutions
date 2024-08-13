class Solution {
    public int findMinMoves(int[] machines) {
        int avg = 0;

        for(int i = 0; i < machines.length; i++){
            avg += machines[i];
            
        }

        if(avg % machines.length != 0){
            return -1;
        }

        int res = 0, cnt = 0;
        avg = avg / machines.length;
        for (int m : machines) {
            cnt += m - avg;
            res = Math.max(res, Math.max(Math.abs(cnt), m - avg));
        }
        return res;
    }
}