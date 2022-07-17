public class LongestTurbulentSubArray {


    public static  int maxTurbulenceSize(int[] arr) {

        if(arr.length==1){
            return 1;
        }
        int current_Max=1+(arr[0]!=arr[1]?1:0);
        int preDiff=arr[1]-arr[0];
        int max=current_Max;

        for(int i=1;i<arr.length-1;i++){
            int postDiff=arr[i+1]-arr[i];

            if(preDiff*postDiff<0){
                current_Max+=1;

            }
            else{
                current_Max=1+(postDiff!=0?1:0);
            }
            max=Math.max(current_Max,max);
            preDiff=postDiff;

        }

        return max;
    }

    public static void main(String[] args) {

        int arr[]={1,3,1,3,1};
        System.out.println(maxTurbulenceSize(arr));

    }

    }
