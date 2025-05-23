class Solution {
    public int minMoves(String[] matrix) {
        int n = matrix.length;
        int m = matrix[0].length();
        ArrayList<int[]> map[] = new ArrayList[26];
        for(int i = 0; i < 26; i++) map[i] = new ArrayList<>();
        char grid[][] = new char[n][m];
        boolean vis[][] = new boolean[n][m];
        char c;
        for(int i = 0; i < n; i++) for(int j = 0; j < m; j++)
            {
                c = matrix[i].charAt(j);
                grid[i][j] = c;
                if(c >= 'A' && c <= 'Z')
                {
                    map[c - 'A'].add(new int[]{i, j});
                }
            }
        int dist = Integer.MAX_VALUE, size;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        vis[0][0] = true;
        int temp[];
        int xdir[] = {0, 1, 0, -1};
        int ydir[] = {1, 0, -1, 0};
        int x, y;
        while(!q.isEmpty())
            {
                temp = q.poll();
                if(temp[0] == n - 1 && temp[1] == m - 1) return temp[2];
                c = grid[temp[0]][temp[1]];
                
                if(c >= 'A' && c <= 'Z')
                {
                    // teleportation
                    for(int edge[] : map[c - 'A'])
                        {
                            if(!vis[edge[0]][edge[1]])
                            {
                                vis[edge[0]][edge[1]] = true;
                                q.add(new int[]{edge[0], edge[1], temp[2]});
                            }
                            map[c - 'A'] = new ArrayList<>();
                        }
                }
                // four direction
                for(int k = 0; k < 4; k++)
                    {
                        x = temp[0] + xdir[k];
                        y = temp[1] + ydir[k];
                        if(x >= 0 && y >= 0 && x < n && y < m && !vis[x][y] && grid[x][y] != '#')
                        {
                            q.add(new int[]{x, y, temp[2] + 1});
                            vis[x][y] = true;
                            if(grid[x][y] >= 'A' && grid[x][y] <= 'Z')
                            {
                                // teleportation
                                for(int edge[] : map[grid[x][y] - 'A'])
                                    {
                                        if(!vis[edge[0]][edge[1]])
                                        {
                                            vis[edge[0]][edge[1]] = true;
                                            q.add(new int[]{edge[0], edge[1], temp[2] + 1});
                                        }
                                        map[grid[x][y] - 'A'] = new ArrayList<>();
                                    }
                            }
                        }
                    }
                        
                    
            }

        return -1;
        
    }
}