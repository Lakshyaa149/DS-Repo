public class SubArrayProductLessThank {


    /*public static  int numSubarrayProductLessThanK(int[] nums, int k) {

        int n=nums.length;
        int product=1;
        int i=0,j=0;
        int total=0;
        while(i<=j && j<n){
            product=product*nums[j];

            if(product>=k){
                int v=j-i;
                total+=((v)*(v+1))/2;
                while(product>=k){
                    product=product/nums[i];
                    i++;
                }
            }
            j++;
        }
        if(product<k) {
            int v = j - i;
            total += ((v) * (v + 1)) / 2;
        }
    return total;
    }*/

    public static  int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];

            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {

        int arr[]={10,5,2,6};
        int k=100;
        System.out.println(numSubarrayProductLessThanK(arr,k));

    }
}
