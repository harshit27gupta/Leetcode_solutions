import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitiveMap = new HashMap<>();
        Map<String, String> vowelInsensitiveMap = new HashMap<>();
        
        for (String word : wordlist) {
            String lowerWord = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lowerWord, word);
            
            String vowelReplacedWord = replaceVowels(lowerWord);
            vowelInsensitiveMap.putIfAbsent(vowelReplacedWord, word);
        }
        
        String[] result = new String[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            
            if (words.contains(query)) {
                result[i] = query;
            } else {
                String lowerQuery = query.toLowerCase();
                
                if (caseInsensitiveMap.containsKey(lowerQuery)) {
                    result[i] = caseInsensitiveMap.get(lowerQuery);
                } else {
                    String vowelReplacedQuery = replaceVowels(lowerQuery);
                    
                    if (vowelInsensitiveMap.containsKey(vowelReplacedQuery)) {
                        result[i] = vowelInsensitiveMap.get(vowelReplacedQuery);
                    } else {
                        result[i] = "";
                    }
                }
            }
        }
        
        return result;
    }
    
    private String replaceVowels(String word) {
        return word.replaceAll("[aeiou]", "#");
    }
}
