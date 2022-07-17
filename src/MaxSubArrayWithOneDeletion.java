public class MaxSubArrayWithOneDeletion {

    public static  int maximumSum(int[] arr) {

        int fw[]=new int[arr.length];
        int bw[]=new int[arr.length];

        int max=Integer.MIN_VALUE;
        int curr_max=arr[0];
        fw[0]=curr_max;
        int n=arr.length;
        for(int i=1;i<n;i++){

            curr_max=Math.max(arr[i],curr_max+arr[i]);
            fw[i]=curr_max;
        }

        bw[n-1]=arr[n-1];
        curr_max=bw[n-1];
        max=curr_max;
        for(int i=n-2;i>=0;i--){
            curr_max=Math.max(arr[i],curr_max+arr[i]);
            bw[i]=curr_max;
            max=Math.max(curr_max,max);
        }
        int res=0;
        for(int i=1;i<n-1;i++){

            max=Math.max(max,fw[i-1]+bw[i+1]);

        }

        return max;

    }

    public static void main(String[] args) {

        int arr[]={1,-2,-2,3};
        System.out.println(maximumSum(arr));
    }
}
