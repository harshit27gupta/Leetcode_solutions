import java.util.Arrays;

class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> a[0] - b[0]); 
        int clipsUsed = 0;
        int currentEnd = 0;
        int farthestEnd = 0;
        int i = 0;
        int n = clips.length;      
        while (i < n && currentEnd < time) {
            while (i < n && clips[i][0] <= currentEnd) {
                farthestEnd = Math.max(farthestEnd, clips[i][1]);
                i++;
            }
            if (currentEnd == farthestEnd) {
                return -1;
            }
            currentEnd = farthestEnd;
            clipsUsed++;
        }
        
        return currentEnd >= time ? clipsUsed : -1;
    }
}
