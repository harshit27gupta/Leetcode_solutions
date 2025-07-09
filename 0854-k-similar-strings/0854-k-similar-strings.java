class Solution {
    public int kSimilarity(String s1, String s2) {
        if(s1.equals(s2)) return 0;
        int n = s1.length();
        Queue<String> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        queue.offer(s1);
        seen.add(s1);

        for(int k = 1; !queue.isEmpty(); k++) { 
            for(int size = queue.size(); size > 0; size--) { 
                String cur = queue.poll();
                int i = 0;
                while(cur.charAt(i) == s2.charAt(i)) i++;
                for(int j = i + 1; j < n; j++) {
                    if(cur.charAt(j) == s2.charAt(j) || 
                     cur.charAt(j) != s2.charAt(i)) continue; 
                    String next = swap(cur, i, j);
                    if(next.equals(s2)) return k;
                    if(seen.add(next)) queue.offer(next);
                }
            }
        }

        return -1;
    }

    private String swap(String s, int i, int j) {
        char[] next = s.toCharArray();
        char temp = next[i];
        next[i] = next[j];
        next[j] = temp;
        return new String(next);
    }
}