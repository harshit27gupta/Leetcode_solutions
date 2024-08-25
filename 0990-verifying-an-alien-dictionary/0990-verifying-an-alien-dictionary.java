class Solution {
    HashMap<Character, Character> map;
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1)
            return true;
        
        map = new HashMap<>();
        int k=0;
        for(char c : order.toCharArray()){
            map.put(c, (char)('a' + k));
            k++;
        }
        for(int i=1; i<words.length; i++){
            String word1 = words[i-1];
            String word2 = words[i];
            int n = word1.length();
            int m = word2.length();
            if(!validate(word1, word2, n, m))
                return false;
        }
             return true;
    }
    public boolean validate(String a, String b, int n, int m){
        StringBuilder a1 = new StringBuilder(),b1 = new StringBuilder();
        
        for(int i=0; i<Math.max(n,m); i++){    
            if(i<n){
                char c1 = a.charAt(i);
                a1.append(map.get(c1));
            }
            if(i<m){
                char c2 = b.charAt(i);
                b1.append(map.get(c2));
            }
        }
        
        return  a1.compareTo(b1) <= 0;
    }
}