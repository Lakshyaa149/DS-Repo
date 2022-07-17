public class BombKill {

    public int maxKilledEnemies(char[][] grid) {
        int max = 0;
        int rowHits = 0;
        int colsHits[] = new int[grid[0].length];
        int rows = grid.length;
        int cols = grid[0].length;


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col == 0 && grid[row][col - 1] == 'W') {
                    rowHits = 0;
                    for (int i = col; i < cols; i++) {
                        if (grid[row][i] == 'W') {
                            break;
                        } else if (grid[row][i] == 'E') {
                            rowHits++;
                        }
                    }
                } else if (row == 0 || grid[row - 1][col] == 'W') {
                    colsHits[col] = 0;
                    for (int j = row; j < rows; j++) {

                        if (grid[j][col] == 'W') {
                            break;
                        } else if (grid[j][col] == 'E') {
                            colsHits[col]++;

                        }
                    }

                }

                if (grid[row][col] == '0') {

                    max = Math.max(rowHits + colsHits[col], max);
                }
            }
        }
     return max;
    }
}
