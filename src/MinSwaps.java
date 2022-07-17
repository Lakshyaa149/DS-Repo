import java.util.Arrays;

public class MinSwaps {

    public static  int minSwaps(int[] nums) {
        int ones= Arrays.stream(nums).sum();

        int j=0;
        int i=0;
        int n=nums.length;

        int currentCount=0;
        while(j<nums.length){

            if(nums[j]==1){
                currentCount++;
            }
            if(j==nums.length-1 && i==0 && currentCount==ones){
                return 0;
            }
            if(currentCount==ones){

                while(i<j&&nums[i]==0){
                    i++;
                }
                return (j-i-ones)+1;
            }
          j++;
        }

        return 0;

    }

    public static void main(String[] args) {

        int nums[]={1,1};
        System.out.println(minSwaps(nums));


    }
}
