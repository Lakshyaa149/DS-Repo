public class MaxProduct {


     static  int weirdStock(int n, int m){
        int res = 0;
        while(n < m){

            int c=m & 1;
            boolean ans=false;
            if(c!=0){
                ans=true;
            }
            m = ans ? m + 1 : m / 2;
            res++;
        }
        return res + (n - m);
    }

    public int getMaxLen(int[] nums) {
        int firstNegative=-1;
        int zeroIndex=-1;
        int sum=0;
        int max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                sum++;
                if(firstNegative==-1){
                    firstNegative=i;
                }
            }

            if(nums[i]==0){
                sum=0;
                zeroIndex=i;
                firstNegative=-1;
            }
            else{
                //
               if(sum%2==0){
                   max=Math.max(i-zeroIndex,max);
               }
               else{
                   //need to neglect the first negative no
                   max=Math.max(i-firstNegative,max);
               }
            }
        }
    return max;
    }

    public static void main(String[] args) {

        int n=10;
        int m=20;

        weirdStock(n,m);

    }
}
