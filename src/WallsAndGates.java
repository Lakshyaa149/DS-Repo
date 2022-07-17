import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

   int directions[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public void wallsAndGates(int[][] rooms) {
        long EMPTY=2147483647;


        Queue<int[]> queue=new LinkedList<>();
        int n= rooms.length;
        int m=rooms[0].length;


        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                if(rooms[i][j]==0){
                    queue.add((new int[]{i,j}));
                }
            }
        }


        while(!queue.isEmpty()){
            int d[]=queue.poll();
            int row=d[0];
            int col=d[1];

            for (int[] direction : directions) {
                int r=row+direction[0];
                int c=col+direction[1];
                if (r >= 0 && c >= 0 && r < n && c < m && rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c]=rooms[row][col]+1;
            }
        }


    }

}
