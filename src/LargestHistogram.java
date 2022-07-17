import java.util.Stack;

public class LargestHistogram {


    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;

        int left[]=new int[n];
        int right[]=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i]=0;
            }
            else{
                left[i]=stack.peek()+1;
            }
            stack.push(i);
        }
        stack=new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i]=n-1;
            }
            else{
                right[i]=stack.peek()-1;
            }
            stack.push(i);
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,((right[i]-left[i]+1)*heights[i]));
        }
      return max;
    }

    public static void main(String[] args) {

        int heights[]={2,1,5,6,2,3,1};
        System.out.println(largestRectangleArea(heights));
    }
}
