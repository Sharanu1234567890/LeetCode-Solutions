import java.util.*;

class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Top-right triangle: diagonals starting from first row, col 1 to n-1 (ascending)
        for (int col = 1; col < n; col++) {
            sortDiagonal(grid, 0, col, true);
        }

        // Bottom-left triangle (including main diagonal): diagonals starting from each row, col 0 (descending)
        for (int row = 0; row < n; row++) {
            sortDiagonal(grid, row, 0, false);
        }

        return grid;
    }

    // Helper to sort a diagonal starting at (row, col)
    private void sortDiagonal(int[][] grid, int row, int col, boolean ascending) {
        int n = grid.length;
        List<Integer> vals = new ArrayList<>();
        int r = row, c = col;

        // Collect the diagonal
        while (r < n && c < n) {
            vals.add(grid[r][c]);
            r++;
            c++;
        }

        // Sort as needed
        if (ascending) {
            Collections.sort(vals);
        } else {
            vals.sort(Collections.reverseOrder());
        }

        // Put sorted values back
        r = row;
        c = col;
        int idx = 0;
        while (r < n && c < n) {
            grid[r][c] = vals.get(idx++);
            r++;
            c++;
        }
    }
}