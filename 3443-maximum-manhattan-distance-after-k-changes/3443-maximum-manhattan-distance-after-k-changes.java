class Solution {
    public int maxDistance(String s, int k) {
        int x = 0, y = 0;
        int dis = 0;

        for (int i = 0; i < s.length(); i++) {
            char dir = s.charAt(i);
            if (dir == 'E') {
                x++;
            } else if (dir == 'W') {
                x--;
            } else if (dir == 'N') {
                y++;
            } else {
                y--;
            }

            int newDis = Math.abs(x) + Math.abs(y);
            dis = Math.max(dis, Math.max(newDis, Math.min(i + 1, newDis + 2 * k)));
        }

        return dis;
    }
}