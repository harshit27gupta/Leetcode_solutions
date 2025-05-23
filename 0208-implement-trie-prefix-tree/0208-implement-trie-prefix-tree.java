class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; 
            isEndOfWord = false;
        }
    }

    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a'; 
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false; 
            }
            node = node.children[index];
        }
        return node.isEndOfWord; 
    }
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false; 
            }
            node = node.children[index];
        }
        return true; 
    }
}

/**
 * Example usage:
 * Trie obj = new Trie();
 * obj.insert("apple");
 * boolean param_2 = obj.search("apple"); // Returns true
 * boolean param_3 = obj.startsWith("app"); // Returns true
 */
