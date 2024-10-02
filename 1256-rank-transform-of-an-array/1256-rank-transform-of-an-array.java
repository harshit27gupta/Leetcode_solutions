class Solution {
    public int[] arrayRankTransform(int[] arr) 
    {
        if(arr.length==0)
        return arr;
        if(arr.length==1)
        return new int[]{1};

        int []arr2=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            arr2[i]=arr[i];
        }

        Arrays.sort(arr);

        Map<Integer,Integer> hm=new HashMap<>();

        int r=1;

        hm.put(arr[0],1);

        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>arr[i-1])
            r++;
            hm.put(arr[i],r);
        }

        int []ans=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            ans[i]=hm.get(arr2[i]);
        }

        return ans;
        
    }
}