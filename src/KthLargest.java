import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargest {



    public static  int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>( Comparator.reverseOrder());

        for(int i=0;i<nums.length;i++){
            heap.add(nums[i]);
        }
        int currentK=0;
        while(currentK<k){
            if(currentK==k-1){
                return heap.peek();
            }
            heap.poll();
            currentK++;

        }
        return -1;
    }

    public static void main(String[] args) {

        int arr[]={3,2,3,1,2,4,5,5,6};
        int k=4;

        System.out.println(findKthLargest(arr,k));
    }
}
