class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)
            return word;
        char arr[]=word.toCharArray();
        char min='a';
        for(char c:arr){
            if(c>min)
                min=c;
        }
        String init="";
        for(int i=0;i<arr.length;i++){
            if(arr[i]==min){
                int left=i;
                int right=arr.length-1;
                if(left<numFriends-1)
                    right+=(left+2-numFriends);
                else
                    right++;
                String check=word.substring(left,right);
                if(check.compareTo(init)>0)
                    init=check;
            }
        }
        return init;
    }
}