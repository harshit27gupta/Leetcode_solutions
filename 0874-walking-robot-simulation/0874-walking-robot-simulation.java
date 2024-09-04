class Solution {
    int max = 0;
    public int[] updatedCoordinates(int[] curr, Set<List<Integer>>set, int k, int dir) {
        int x = curr[0], y = curr[1];
        if(dir == 0) {
            while(k-- > 0){
                if(set.contains(List.of(x,y+1))) {
                    break;
                }
                y++;
            }
        } else if(dir == 1) {
            while(k-- > 0){
                if(set.contains(List.of(x+1,y))) {
                    break;
                }
                x++;
            }
        } else if(dir == 2) {
            while(k-- > 0){
                if(set.contains(List.of(x,y-1))) {
                    break;
                }
                y--;
            }
        } else {
            while(k-- > 0){
                if(set.contains(List.of(x-1,y))) {
                    break;
                }
                x--;
            }
        }
        max = Math.max(max, x*x+y*y);
        return new int[]{x,y};
    }
    public int robotSim(int[] commands, int[][] obstacles) {

        int direction = 0;
        int [] curr = {0, 0};
        Set<List<Integer>>set = new HashSet<>();
        for(int[] obstacle : obstacles){
            set.add(List.of(obstacle[0], obstacle[1]));
        }
        for(int command : commands) {
            if(command == -1){
                direction = (direction+1)%4;
            } else if(command == -2) {
                direction = (direction+3)%4;
            } else {
                curr = updatedCoordinates(curr, set, command, direction);
            }
        }
        max = Math.max(max, curr[0]*curr[0] + curr[1]*curr[1]);
        return max;
    }
}