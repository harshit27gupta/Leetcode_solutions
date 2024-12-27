import java.util.*;

class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++)
            parent[i] = i;
      for (int i = 0; i < s1.length(); i++) {
            int char1 = s1.charAt(i) - 'a';
            int char2 = s2.charAt(i) - 'a';
            union(parent, char1, char2);
        }
        for (int i = 0; i < 26; i++)
            parent[i] = find(parent, i);
        StringBuilder sb = new StringBuilder();
        for (char ch : baseStr.toCharArray()) {
            int smallestEquivalent = find(parent, ch - 'a');
            sb.append((char) (smallestEquivalent + 'a'));
        }

        return sb.toString();
    }
    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        if (rootX != rootY) {
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); 
        }
        return parent[x];
    }
}
