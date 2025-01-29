class Solution {
    static int find(int x,int parent[]){
        if(parent[x]==x)
        return x;
        return parent[x]=find(parent[x],parent);
    }
     static void union(int x, int y, int parent[], int size[]) {
        int rootX = find(x, parent);
        int rootY = find(y, parent);
        
        if (rootX != rootY) {
            if (size[rootX] >= size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int parent[]=new int[n+1];
        int size[]=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(find(u,parent)==find(v,parent))
            return new int[]{u,v};
            union(u,v,parent,size);
        }
        return new int[]{-1};

    }
}