class WordFilter {
    private Map<String, Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int len = word.length();
            for (int prefLen = 1; prefLen <= len; prefLen++) {
                for (int suffLen = 1; suffLen <= len; suffLen++) {
                    String key = word.substring(0, prefLen) + "#" + word.substring(len - suffLen);
                    map.put(key, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        String key = pref + "#" + suff;
        return map.getOrDefault(key, -1);
    }
}
