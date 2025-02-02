class Solution {
    public int maxDifference(String s) {
        int freq[]=new int[26];
        for(char c:s.toCharArray())
        freq[c-'a']++;
        int ev_min=101,ev_max=0;
        int odd_min=101,odd_max=0;
        for(int i:freq){
            if(i%2==0){
                if(i!=0)
                ev_min=Math.min(ev_min,i);
                ev_max=Math.max(ev_max,i);
            }
            else{
                  odd_min=Math.min(odd_min,i);
                odd_max=Math.max(odd_max,i);
            }
        }
        return odd_max-ev_min;
    }
}