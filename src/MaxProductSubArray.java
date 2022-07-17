public class MaxProductSubArray {

    public static  int maxProduct(int[] nums) {

        int min=nums[0];
        int max=nums[0];
        int result=max;
        int temp_max=0;
        for(int i=1;i<nums.length;i++){

            temp_max=Math.max(nums[i],Math.max(min*nums[i],max*nums[i]));
            min=Math.min(nums[i],Math.min(min*nums[i],max*nums[i]));

            max=temp_max;
            result=Math.max(result,max);

        }

        return result;

    }

    public static void main(String[] args) {

        int arr[]={-4,-3,-2};
        System.out.println(maxProduct(arr));

    }
}
