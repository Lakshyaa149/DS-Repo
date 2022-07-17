import java.util.function.Consumer;

public class TwoArraysXor {

    public static  int countTriplets(int[] A) {
        int n = A.length + 1, res = 0, prefix[] = new int[n];

        for(int i=1;i<n;i++){
            prefix[i]=A[i-1]^prefix[i-1];
        }
        for(int i=0;i<n-1;i++){
            int xor=prefix[i];
            for(int j=i+1;j<n;j++){
                int xorTotal=xor^prefix[j];
                if(xorTotal==0){
                    res+=j-i-1;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

        int arr[]={1,3,5,7};
        Consumer c=System.out::println;
        c.accept(countTriplets(arr));

    }
}
