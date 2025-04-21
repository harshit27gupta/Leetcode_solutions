class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long score=0;
        int i=0;
        boolean visited[]=new boolean[instructions.length];
        while(i>=0 && i<instructions.length){
            if(visited[i])
            break;
            visited[i]=true;
         if(instructions[i].equals("add"))
            score+=values[i++];
            else
            i+=values[i];
        }
        return score;
    }
}