import java.util.Arrays;

public class NextPermutation4 {


    public static  void nextPermutation(int[] nums) {

        //7 8 8 9 8
        int index=-1;
        int i=0;
        for( i=nums.length-1;i>0;i--) {
            index=findSmallestIndexFromLast(nums,i );
            if(index !=-1){
                break;
            }
        }
        //swap
        if(index!=-1) {
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;


            int newArray[] = new int[nums.length - index - 1];

            int v = 0;
            for (int j = index + 1; j < nums.length; j++) {
                newArray[v] = nums[j];
                v++;
            }
            Arrays.sort(newArray);

            v = 0;
            for (int k = index + 1; k < nums.length; k++) {
                nums[k] = newArray[v];
                v++;
            }
            for (int k = 0; k < nums.length; k++) {
                System.out.println(nums[k]);
            }
        }

    }

    private static int findSmallestIndexFromLast(int[] nums, int index) {
        int firstSmallIndex=-1;

        int currentIndex=index-1;
        while(currentIndex>=0 && nums[currentIndex]>=nums[index]){
            currentIndex--;
        }
        if(currentIndex>=0 && nums[currentIndex]<nums[index]) {
            firstSmallIndex = currentIndex;
        }
        return firstSmallIndex;
    }

    public static void main(String[] args) {

        int nums[]={3,2,1};
        nextPermutation(nums);

    }
}
