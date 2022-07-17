import java.util.HashMap;
import java.util.Map;

public class LFS {

    public int lenLongestFibSubseq(int[] A) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=A.length;
        int dp[][]=new int[n][n];
        int max=Integer.MIN_VALUE;

        for(int j=0;j<A.length;j++){
            map.put(A[j],j);
            for(int i=0;i<j;i++){

                int k=map.getOrDefault(A[j]-A[i],-1);
                dp[i][j]=(A[j]-A[i]<A[i] && k>=0?dp[k][i]+1:2);
                max=Math.max(dp[i][j],max);
            }
        }

      return max>2?max:2;
    }
    public static void main(String[] args) {


    }
}
