public class NumberOfSubArraysLessThanK {

   static  int kthSmallestSubarraySum(int  nums[], int k) {
        int low = 0, high = 1000000000; //kth smallest must be in this range
        while(low < high) {
            int mid = low + (high - low)/2;
            //see if there are at least k subarrays with sum <= mid
            if(countSubarray(nums, mid) >= k) high = mid;
            else low = mid + 1;
        }
        return low; //kth smallest
    }

    static int countSubarray(int nums[],
                              int k)
    {
        int count = 0;
        int sum = 0;
        int left = 0, right = 0;
        int n=nums.length;// [left, right)
        while(right < n) { // invariant: sum <= target
            sum += nums[right++];
            while(sum > k) {
                sum -= nums[left++];
            }
            count += right - left;
        }
        return count;
    }

    public static void main(String[] args) {

        int arr[]={1,2,3,4,5};
        int k=7;

        System.out.println(countSubarray(arr,k));


    }

}
