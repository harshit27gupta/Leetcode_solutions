import java.util.*;

class Solution {
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return x == p.x && y == p.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int distinctPoints(String s, int k) {
        int n = s.length();
        int[] px = new int[n], py = new int[n];
        int[] sx = new int[n], sy = new int[n];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'U') y++;
            else if (s.charAt(i) == 'D') y--;
            else if (s.charAt(i) == 'L') x--;
            else x++;
            px[i] = x;
            py[i] = y;
        }
        x = 0; y = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == 'U') y++;
            else if (s.charAt(i) == 'D') y--;
            else if (s.charAt(i) == 'L') x--;
            else x++;
            sx[i] = x;
            sy[i] = y;
        }
        Set<Pair> st = new HashSet<>();
      for (int le = 0; le + k <= n; le++) {
    int lx = (le == 0 ? 0 : px[le - 1]);
    int ly = (le == 0 ? 0 : py[le - 1]);
    int rx = (le + k < n ? sx[le + k] : 0);
    int ry = (le + k < n ? sy[le + k] : 0);
    st.add(new Pair(lx + rx, ly + ry));
}


        return st.size();
    }
}
