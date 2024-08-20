class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int cycleLength = 14; 
        n = (n - 1) % cycleLength + 1; 

        for (int day = 0; day < n; day++) {
            int[] nextCells = new int[8];
            for (int i = 1; i < 7; i++) {
                nextCells[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
            }
            cells = nextCells; 
        }
        return cells;
    }
}
