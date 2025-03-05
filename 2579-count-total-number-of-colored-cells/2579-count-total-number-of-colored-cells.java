class Solution {
    public long coloredCells(int n) {
        return 1 + (long) n * (n - 1) * 2;
        //each iteration adds a multiple of 4 new cells to the existing structure.
        // the number of cells added at each step follows the sequence: 
        //  4, 8, 12, 16, ..., increasing by 4 every time.
        //This means the total count follows the sum:
        //     1+(4×1)+(4×2)+...+(4×(n−1))
        //  =1+2×(n−1)×n
    }
}
