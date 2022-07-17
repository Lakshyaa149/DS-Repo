public class MaxSumTwoOverlapping {


    public static int maxSumTwoNoOverlap(int[] nums, int L, int M) {

        if (null == nums || nums.length == 0 || nums.length < L + M)
            return -1;

        return Math.max(maxSum(nums, L, M), maxSum(nums, M, L));
    }

    private static int maxSum(int nums[], int L, int M) {
        int n=nums.length;
        int LPreSum[]=new int[n];
        int RPreSum[]=new int[n];
        int leftSum=nums[0];
        int rightSum=nums[n-1];
        LPreSum[0]=leftSum;
        RPreSum[n-1]=rightSum;
        for(int i=1,j=n-2;i<=n && j>=0;i++,j--){
            leftSum+=nums[i];

            if(i>=L){
                leftSum-=nums[i-L];
            }

            LPreSum[i]=Math.max(LPreSum[i-1],leftSum);

            rightSum+=nums[j];

            if(j+M<n){
                rightSum-=nums[j+M];
            }
            RPreSum[i]=Math.max(RPreSum[i+1],rightSum);
        }
        return -1;
    }
}
