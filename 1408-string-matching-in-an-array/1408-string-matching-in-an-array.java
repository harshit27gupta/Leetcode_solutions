class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words.length;j++){
                if(i==j)
                continue;
                if(words[j].indexOf(words[i])>=0){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}