class Solution {
    public boolean isPalindrome(int x) {
        int y=0;
        for(int i=x;i>0;i=i/10){
            int j=i%10;
            y=y*10+j;
        }
        return (y==x);
    }
}