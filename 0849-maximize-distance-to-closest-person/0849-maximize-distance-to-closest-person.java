class Solution {
    public int maxDistToClosest(int[] seats) {
        ArrayList<Integer> indices=new ArrayList<>();
        for(int i=0;i<seats.length;i++){
           if(seats[i]==1)
           indices.add(i);
        }
        int ans=Math.max(indices.get(0),seats.length-1-indices.get(indices.size()-1));
        for(int i=1;i<indices.size();i++){
            int dist=indices.get(i)-indices.get(i-1);
            if(dist==1)
            continue;
            ans=Math.max(ans,dist/2);
        }
        return ans;
    }
}