class Solution {
    public char kthCharacter(int k) {
        String ini="a";
        while(ini.length()<k){
            String res="";
            for(char c:ini.toCharArray())
            res+=(char)((int)(c)+1);
            ini+=res;
        }
        return ini.charAt(k-1);
    }
}