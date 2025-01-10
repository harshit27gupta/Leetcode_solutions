class Solution {
    public int maxRepOpt1(String text) {
        int[] freq = new int[255];
        for (char ch : text.toCharArray())
            freq[ch]++;
        int res = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (freq[ch] == 0)
                continue;
            int i = 0, gap = 0;
            for (int j = 0; j < text.length(); j++) {
                gap = text.charAt(j) != ch ? gap + 1 : gap;
                if (ch == text.charAt(j))
                    freq[ch]--;
                while ((gap == 1 && freq[ch] == 0) || gap > 1) {
                    if (ch == text.charAt(i))
                        freq[ch]++;
                    else
                        gap--;
                    i++;
                }
                if ((gap == 1 && freq[ch] > 0) || gap == 0)
                    res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }
}