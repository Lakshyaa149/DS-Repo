import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum3 {
    public static  List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int prev=-1;
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>0) {
                break;
            }
            if(i==0 || nums[i-1]!=nums[i]){
                bs(nums,i,list);
                }
        }
        return list;
    }
    public static void bs(int nums[],int i,List<List<Integer>> list){
        
        int current=i;

        int low=i+1;
        int high=nums.length-1;

        while(low<high){

            int sum=nums[current]+nums[low]+nums[high];
            if(sum<0){
               low++;
            }
            else if(sum>0){
            high--;
            }
            else{
                list.add(Arrays.asList(nums[current],nums[low++],nums[high--]));
                while(low==low-1 && low<high){
                    low++;
                }
            }
        }
    }

    public static void main(String[] args) {

        int nums[]={-4,-1,-1,0,1,2};
        System.out.println(threeSum(nums));
    }
}
