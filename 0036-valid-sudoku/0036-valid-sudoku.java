import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        // Iterate over each cell in the 9x9 board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;  // Skip empty cells
                }
                
                // Store the current number as an integer
                int num = board[i][j];
                
                // Check and add to the set for row, column, and box
                if (!seen.add(num + " seen in row " + i) ||
                    !seen.add(num + " seen in column " + j) ||
                    !seen.add(num + " seen in box " + (i / 3) + "-" + (j / 3))) {
                    return false;  // Duplicate found
                }
            }
        }
        
        return true;  // No duplicates found, valid Sudoku
    }
}
