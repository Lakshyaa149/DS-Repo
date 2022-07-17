public class CherryPickup {
public  static int max=0;
    public void cp1(int row,int col,int grid[][],int ccc){

        max=Integer.MIN_VALUE;
        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==-1){
            return;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            max=Math.max(max,ccc);


        }
        int cherries=grid[row][col];
        grid[row][col]=0;

        cp1(row,col+1,grid,ccc+cherries);
        cp1(row+1,col,grid,ccc+cherries);
        grid[row][col]=cherries;

    }
    public void helper(int row,int col,int grid[][],int ccc){

        if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]==-1){
            return;
        }

        if(row==0 && col==0){
            max=Math.max(max,ccc);
           return;
        }
        int cherries=grid[row][col];
        grid[row][col]=0;

        cp1(row,col-1,grid,ccc+cherries);
        cp1(row-1,col,grid,ccc+cherries);
        grid[row][col]=cherries;
    }
}
