public class Battleships {

    int dx[] = {1, 0};
    int dy[] = {0, 1};

    public int countBattleships(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean dp[][] = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'X' && dp[i][j] != true) {
                    dfs(i, j, board, dp);
                    count++;
                }
            }
        }
        return count;
    }


    private void dfs(int i, int j, char[][] board, boolean dp[][]) {
        dp[i][j] = true;
        for (int k = 0; k < 2; k++) {
            int x = i + dx[i];
            int y = j + dy[i];

            if (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == 'X') {
                dfs(x, y, board, dp);
            }

        }
    }
}
