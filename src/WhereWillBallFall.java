public class WhereWillBallFall {

    public int[] findBall(int[][] grid) {

        int result[]=new int[grid.length];
        for(int i=0;i<grid[0].length;i++){

            dfs(grid,i,0,i,result);
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int row, int col,int result[]) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length ){
            return;
        }

        if(row== grid.length-1 && ((col==0 && grid[row][col]==-1) || (col==grid[0].length-1 && grid[row][col]==1))){
            result[i]=col;
            return;
        }
        else if(row== grid.length-1){
            result[i]=1;
            return;
        }

        if(grid[row][col]==1 && checkDiagonalCondition(row,col+1,grid,-1)){
            result[i]=-1;
        }
        else if(grid[row][col]==1){
            dfs(grid,i,row+1,col+1,result);
        }
        else if(grid[row][col]==-1 && checkDiagonalCondition(row,col-1,grid,1)){
            result[i]=-1;
        }
        else{
            dfs(grid,i,row+1,col-1,result);
        }

    }

    private boolean checkDiagonalCondition(int row,int col,int grid[][],int check) {

        if(col>= grid.length || grid[row][col]==check){
            return true;
        }
     return false;
    }

    public static void main(String[] args) {


    }
}
