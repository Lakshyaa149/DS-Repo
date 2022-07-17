import java.util.HashMap;
import java.util.Map;

public class MinimiumOperations {


    public static int minimumOperations(int[] nums) {
        Map<Integer,Integer>  evenIndicesFreqMap=new HashMap<>();
        Map<Integer,Integer>  oddIndicesFreqMap=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                evenIndicesFreqMap.put(nums[i],evenIndicesFreqMap.getOrDefault(nums[i],0)+1);
            } else{
                oddIndicesFreqMap.put(nums[i],oddIndicesFreqMap.getOrDefault(nums[i],0)+1);
            }
        }

        Integer firstMaxFreqElementEven=0;
        Integer secondMaxFreqElementEven=0;
        evenIndicesFreqMap.put(0,0);
        oddIndicesFreqMap.put(0,0);
        //Find max freq element and second max freq element for even
        for (Integer key:evenIndicesFreqMap.keySet()) {
            if(evenIndicesFreqMap.get(firstMaxFreqElementEven)<evenIndicesFreqMap.get(key)){
                secondMaxFreqElementEven=firstMaxFreqElementEven;
                firstMaxFreqElementEven=key;

            }else if(evenIndicesFreqMap.get(key)>evenIndicesFreqMap.get(secondMaxFreqElementEven)){
                secondMaxFreqElementEven=key;

            }
        }
        //Find max freq element and second max freq element for even
        Integer firstMaxFreqElementOdd=0;
        Integer secondMaxFreqElementOdd=0;
        for (Integer key:oddIndicesFreqMap.keySet()) {
            if(oddIndicesFreqMap.get(firstMaxFreqElementOdd)<oddIndicesFreqMap.get(key)){
                secondMaxFreqElementOdd=firstMaxFreqElementOdd;
                firstMaxFreqElementOdd=key;

            }else if(oddIndicesFreqMap.get(key)>oddIndicesFreqMap.get(secondMaxFreqElementOdd)){
                secondMaxFreqElementOdd=key;

            }
        }
        return firstMaxFreqElementEven==firstMaxFreqElementOdd ? nums.length-Math.max(evenIndicesFreqMap.get(firstMaxFreqElementEven)+oddIndicesFreqMap.get(secondMaxFreqElementOdd),
                oddIndicesFreqMap.get(firstMaxFreqElementOdd)+evenIndicesFreqMap.get(secondMaxFreqElementEven)):nums.length-(evenIndicesFreqMap.get(firstMaxFreqElementEven)+oddIndicesFreqMap.get(firstMaxFreqElementOdd));

    }

    public static void main(String[] args) {

        int arr[]={3,1,3,2,4,3};

        System.out.println(minimumOperations(arr));


    }
}
