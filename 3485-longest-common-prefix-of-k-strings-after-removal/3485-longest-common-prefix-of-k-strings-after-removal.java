class Solution {
    public int[] longestCommonPrefix(String[] words, int k) {
        int n = words.length;
        int[] res = new int[n];
        if(k == n) return res;

        Trie trie = new Trie();
        for(String word : words) {
            trie.insert(word);
        }
        trie.trimBranches(k);
        trie.calcDepth();

        for(int i = 0; i < n; i++) {
            Trie curr = trie;
            int m = words[i].length();

            for(int j = 0; j < m && curr != null && curr.wordCnt > k; j++) {
                int ind = words[i].charAt(j)-'a';
                for(int c = 0; c < 26; c++) {
                    if(c != ind && curr.children[c] != null) {
                        res[i] = Math.max(res[i], curr.children[c].depth + j);
                    }
                }
                curr = curr.children[ind];
                res[i] = Math.max(res[i], j);
            }
            if(curr != null && curr.wordCnt > k) res[i] = Math.max(res[i], curr.depth + m - 1);
            
        }

        return res;


    }

    class Trie {
        Trie[] children;
        int wordCnt;
        int depth;
        public Trie() {
            children = new Trie[26];
            wordCnt = 0;
            depth = 1;
        }

        public void insert(String word) {
            Trie curr = this;
            int n = word.length();
            curr.wordCnt++;

            for(int i = 0; i < n; i++) {
                int index = word.charAt(i)-'a';
                if(curr.children[index] == null) curr.children[index] = new Trie();
                curr = curr.children[index];
                curr.wordCnt++;
            }
        }

        public void trimBranches(int k) { 
            for(int i = 0; i < 26; i++) {
                if(this.children[i] == null) continue;
                if(this.children[i].wordCnt < k) {
                    this.children[i] = null;
                } else {
                    this.children[i].trimBranches(k);
                }
            }
        }
        public int calcDepth() {
            for(int i = 0; i < 26; i++) {
                if(this.children[i] != null) depth = Math.max(depth, 1 + this.children[i].calcDepth());
            }
            return depth;
        }
    }
}