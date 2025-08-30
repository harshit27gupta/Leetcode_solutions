class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Object>[] rowMaps = new Map[9];
        Map<Character, Object>[] colMaps = new Map[9];
        Map<Character, Object>[] subBoxMaps = new Map[9];
        for (int i = 0; i < 9; i++) {
            rowMaps[i] = new HashMap<>();
            colMaps[i] = new HashMap<>();
            subBoxMaps[i] = new HashMap<>();
        }

        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                char value = board[rowIndex][colIndex];
                if (value != '.') {
                    if (rowMaps[rowIndex].put(value, new Object()) != null) {
                        return false;
                    }
                    if (colMaps[colIndex].put(value, new Object()) != null) {
                        return false;
                    }
                    int subBoxIndex = 3 * (rowIndex / 3) + (colIndex / 3);
                    if (subBoxMaps[subBoxIndex].put(value, new Object()) != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}