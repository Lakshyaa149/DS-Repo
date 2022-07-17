public class MaximiumNonNegativeProduct {

    public  static  int max=0;
    public static int maxProductPath(int[][] grid) {

        max=Integer.MAX_VALUE;
        findMaxProduct(grid,0,0,grid.length,grid[0].length,1);

        return max<0?-1:max;

    }

    public  static void   findMaxProduct(int[][] grid, int row, int col, int length, int length1,int product) {
        if(row>=length || col>=length1){
            return;
        }

        if(row==length-1 && col==length1-1){
            product=product*grid[row][col];
            max=Math.max(product,max);
             return;
        }


        findMaxProduct(grid,row+1,col,length,length1,product*grid[row][col]);
        findMaxProduct(grid,row,col+1,length,length1,product*grid[row][col]);
    }

    public static void main(String[] args) {

        int arr[][]={{1,3},{0,-4}};

        System.out.println(maxProductPath(arr));

    }

}
