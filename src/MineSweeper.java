public class MineSweeper {

    public char[][] updateBoard(char[][] board, int[] click) {

        int x=click[0];
        int y=click[1];

        if(board[x][y]=='M'){
            board[x][y]='B';
            return board;
        }
        dfs(board,x,y);
     return board;
    }

    int[] dx = {-1, 0, 1, -1, 1, 0, 1, -1};
    int[] dy = {-1, 1, 1, 0, -1, -1, 0, 1};

    private void dfs(char[][] board, int x, int y) {

        if(x<0 || y>=board[0].length || x>=board.length || y<0 || board[x][y]!='E')
            return;

        int noOfBombs=getNoOfBombs(board,x,y);

        if(noOfBombs==0){
            board[x][y]='B';
            for(int i=0;i<8;i++){
                int newX=dx[i]+x;
                int newY=dy[i]+y;
                dfs(board,newX,newY);
            }
        }
        else{
            board[x][y]=(char)('0'+noOfBombs);
        }
    }

    private int  getNoOfBombs(char[][] board, int x, int y) {

        int noOfBombs=0;
        for(int i=0;i<8;i++){

            int newX=dx[i]+x;
            int newY=dy[i]+y;

            if(board[newX][newY]=='M' || board[newX][newY]=='X'){
                noOfBombs++;
            }

        }
    return noOfBombs;
    }


}
