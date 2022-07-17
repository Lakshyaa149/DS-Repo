import java.util.Arrays;

public class NLIS {

    public static int findNumberOfLIS(int[] nums) {

        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);

        int max=1;
        for(int i=1;i<n;i++){

            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            max=Math.max(max,dp[i]);
        }


        int not=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max){
                not++;
            }
        }

        return not;
    }

    public static void main(String[] args) {
        int arr[]={1,3,5,4,7};
        findNumberOfLIS(arr);
    }
}
