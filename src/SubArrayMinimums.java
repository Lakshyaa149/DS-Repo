/*
import java.util.Arrays;
import java.util.Stack;

public class SubArrayMinimums {

    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int ngl[]=new int[n];
        int ngr[]=new int[n];

        int nsl[]=new int[n];
        int nsr[]=new int[n];
        Arrays.fill(ngl,-1);
        Arrays.fill(ngr,-1);
        Arrays.fill(nsl,-1);
        Arrays.fill(nsr,-1);

        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){

            while(stack.isEmpty()&& stack.peek()<arr[i]){

                ngl[stack.peek()]=i;
                stack.pop();
            }
            stack.push(arr[i]);
        }
        Stack<Integer> stack1=new Stack<>();
        for(int i=n-1;i>=0;i--){

            while(stack1.isEmpty()&& stack1.peek()<arr[i]){

                ngr[stack1.peek()]=i;
                stack1.pop();
            }
            stack.push(arr[i]);
        }
        Stack<Integer> stack2=new Stack<>();
        for(int i=0;i<n;i++){

            while(stack2.isEmpty()&& stack2.peek()>arr[i]){

                nsl[stack2.peek()]=i;
                stack2.pop();
            }
            stack.push(arr[i]);
        }
        Stack<Integer> stack3=new Stack<>();
        for(int i=n-1;i>=0;i--){

            while(stack3.isEmpty()&& stack3.peek()>arr[i]){

                nsr[stack3.peek()]=i;
                stack3.pop();
            }
            stack.push(arr[i]);
        }


    }
}
*/

import java.util.Arrays;
import java.util.Stack;

class SubArrayMinimums {
    public static  long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sum=0;
        Stack<Integer> st = new Stack<>();
        int[] minPrev = new int[n];
        int[] minNext = new int[n];
        int[] maxPrev = new int[n];
        int[] maxNext = new int[n];

        Arrays.fill(minPrev , -1);
        Arrays.fill(minNext , n);
        Arrays.fill(maxPrev , -1 );
        Arrays.fill(maxNext , n);


        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                minPrev[i] = st.peek();
            }

            st.push(i);
        }

        st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                minNext[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        for(int i=0 ;i<n ;i++){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                maxPrev[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        for(int i=n-1 ; i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }

            if(!st.isEmpty()){
                maxNext[i] = st.peek();
            }

            st.push(i);
        }


        for(int i=0 ;i <n;i++){
            long leftMin = i-minPrev[i];
            long rightMin = minNext[i]-i;
            long leftMax = i-maxPrev[i];
            long rightMax = maxNext[i]-i;
            sum+= (leftMax*rightMax - leftMin*rightMin)*nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3};
        System.out.println(subArrayRanges(arr));

    }
}
