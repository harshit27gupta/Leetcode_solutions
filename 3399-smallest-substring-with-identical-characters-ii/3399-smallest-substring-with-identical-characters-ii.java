class Solution {
    static boolean isValid(String s,int numOps,int mid){
        char prev='a';
    int cnt=0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i)==prev)
        cnt++;
        else {
            int flips=cnt/(mid+1);
            numOps-=flips;
        prev=s.charAt(i);
        cnt=1;
        }
    }
    if(cnt>mid)
    numOps-=cnt/(mid+1);
    return (numOps>=0);
    }
    public int minLength(String s, int numOps) {
        int low=1;
        int high=s.length();
        int min_len=s.length();
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(s,numOps,mid)){
                min_len=mid;
                high=mid-1;
            }
            else
            low=mid+1;
        }
        return min_len;
    }
}