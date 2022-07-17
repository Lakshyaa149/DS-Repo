import java.util.HashMap;

public class MinimiumSumNonOverlapping {

    public static  int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int sum=0;
        int min[]=new int[n];

        int res=Integer.MAX_VALUE;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            min[i]=(i>0)?min[i-1]:Integer.MAX_VALUE;
            if(map.containsKey(sum-target)){
                int pre=map.get(sum-target);
                min[i]=Math.min(min[i],i-pre);
                if(pre!=-1 && min[pre]!=Integer.MAX_VALUE){
                    res=Math.min(res,min[pre]+i-pre);
                }
            }
            map.put(sum,i);
        }
        return res;
    }

    public static void main(String[] args) {

        int arr[]={1,2,3,1,1,1};
        int target=3;
        System.out.println(minSumOfLengths(arr,3));

    }
}
