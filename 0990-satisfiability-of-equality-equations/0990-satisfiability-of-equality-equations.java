class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int p1 = find(parent, eq.charAt(0) - 'a');
                int p2 = find(parent, eq.charAt(3) - 'a');
                if (p1 != p2) {
                    parent[p1] = p2;
                }
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int p1 = find(parent, eq.charAt(0) - 'a');
                int p2 = find(parent, eq.charAt(3) - 'a');
                if (p1 == p2) {
                    return false;
                }
            }
        }

        return true;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
