class Solution {
    static boolean poss(int n,int derived[],int in){
        int arr[]=new int[n];
        arr[0]=in;
        for(int i=0;i<n-1;i++){
            if(derived[i]==arr[i])
            arr[i+1]=0;
            else
            arr[i+1]=Math.max(arr[i],derived[i]);
        }
        return (derived[n-1]==(arr[n-1]^arr[0]));
    }
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length;
        return poss(n,derived,1) || poss(n,derived,0);
    }
}