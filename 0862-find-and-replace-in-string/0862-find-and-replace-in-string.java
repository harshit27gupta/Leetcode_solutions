class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        int[] match = new int[n];
        Arrays.fill(match, -1);

        for(int i = 0; i < indices.length; i++){
            if(indices[i] + sources[i].length() <= s.length() && s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i])){
                match[indices[i]] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < n){
            if(match[idx] != -1){
                sb.append(targets[match[idx]]);
                idx += sources[match[idx]].length();
            }
            else{
                sb.append(s.charAt(idx));
                idx++;
            }
        }

        return sb.toString();
    }
}