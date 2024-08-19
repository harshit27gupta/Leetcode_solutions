class Solution {
    public List<String> wordSubsets( String[] words1,  String[] words2) {
         int[] characters = new int[26];
         List<String> subSets = new ArrayList<>();

         for(String word2 : words2) {
             int[] count = new int[26];

            for( char c : word2.toCharArray())
                count[c - 'a']++;

            for(int i = 0; i < 26; ++i)
                characters[i] = Math.max(characters[i], count[i]);
         }

        for( String word1 : words1) {
             int[] count = new int[26];

            for( char c : word1.toCharArray())
                count[c - 'a']++;

            boolean valid = true;

            for(int i = 0; i < 26; ++i) {
                if(count[i] < characters[i]) {
                    valid = false;
                    break;
                }
            }

            if(valid)
                subSets.add(word1);
        }

        return subSets;
    }
}