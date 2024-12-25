class Solution {
    class Garden {
    public static final int[] FLOWER_TYPES = {1,2,3,4};
    int flowerType;
    List<Garden> connectedGardens;
    
    public Garden() {
        flowerType = -1;
        connectedGardens = new ArrayList<Garden>();
    }
 void setUniqueFlowerType() {
	HashSet<Integer> takenByConnectedGarden = new HashSet();
	for(Garden garden : connectedGardens){
		if(garden.flowerType != -1){
			takenByConnectedGarden.add(garden.flowerType);
		}
	}
        
    for(int flowerType : FLOWER_TYPES){
        if(!takenByConnectedGarden.contains(flowerType)){
            this.flowerType = flowerType;
			break;
		}
	}
}
    }
    public int[] gardenNoAdj(int N, int[][] paths) {
        Garden[] graph = new Garden[N];
        for(int i=0; i<N; i++)
            graph[i] = new Garden();
        for(int[] path : paths){
            int p1 = path[0]-1;
            int p2 = path[1]-1;
            Garden garden1 = graph[p1];
            Garden garden2 = graph[p2];
            garden1.connectedGardens.add(garden2);
            garden2.connectedGardens.add(garden1);
        }        
        int idx = 0;
        int[] res = new int[N];
        for(Garden garden : graph){
            garden.setUniqueFlowerType();
            res[idx++] = garden.flowerType;
        }
        
        return res;
    }
}