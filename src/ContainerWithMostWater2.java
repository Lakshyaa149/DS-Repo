public class ContainerWithMostWater2 {

    public static  int maxArea(int[] height) {
        int n=height.length;
        int i=0;
        int j=n-1;
        int max=0;
        while(i<j){
            max=Math.max(max,(j-i)*Math.min(height[i],height[j]));
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int height[]={1,4,6,5,3,7,6,2};
        System.out.println(maxArea(height));
    }
}
