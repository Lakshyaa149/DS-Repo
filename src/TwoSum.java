import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])&&target-nums[i]==0){
                int result[]=new int[2];
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                return result;
            }
            else{
                map.put(nums[i],i);
            }


        }

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
                int result[]=new int[2];
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                return result;
            }

        }
        return new int[2];
    }

    public static void main(String[] args) {


        int arr[]={3,2,4};
        int target=6;
        int nums[]=twoSum(arr,target);
        for(int i=0;i<nums.length;i++){

            System.out.print(nums[i]);
        }

    }
}
