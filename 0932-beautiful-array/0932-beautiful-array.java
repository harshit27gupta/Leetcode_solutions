class Solution {
    public int[] beautifulArray(int n) {
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(1);
        for(int i=2;i<=n;i++){
            ArrayList<Integer>temp=new ArrayList<>();
            for(Integer e:ans){
                if(2*e<=n) temp.add(2*e);
            }
            for(Integer e:ans){
                if(2*e-1<=n) temp.add(2*e-1);
            }
            ans=temp;
        }
        int[] arr=new int[n];
        int k=0;
        for(int i=0;i<ans.size();i++){
            arr[k++]=ans.get(i);
        }
        return arr;
    }
}