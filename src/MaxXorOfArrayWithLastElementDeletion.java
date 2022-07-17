import java.util.function.Consumer;

public class MaxXorOfArrayWithLastElementDeletion {

    public static  int[] getMaximumXor(int[] nums, int maximumBit) {
        int result[]=new int[nums.length];
        int xor[]=new int[nums.length];
        xor[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            xor[i]=xor[i-1]^nums[i];
        }
        result[0]=xor[nums.length-1]^(1<<maximumBit)-1;
        int n=nums.length;
        for(int i=1;i<=nums.length-1;i++){
            int mid=xor[n-i]^nums[n-i];
            result[i]=mid^(1<<maximumBit)-1;
        }

        return result;
    }

    public static void main(String[] args) {

        int nums[]={2,3,4,7};

        Consumer<Integer> c=System.out::println;
        int a[]=getMaximumXor(nums,3);
        for(int i=0;i<a.length;i++){
            c.accept(a[i]);
        }

    }
}
