import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaintingOverlapping {

    public static  List<List<Long>> splitPainting(int[][] segments) {

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int arr[]:segments){
            map.put(arr[0],map.getOrDefault(arr[0],0)+arr[2]);
            map.put(arr[1],map.getOrDefault(arr[1],0)-arr[2]);
        }

        List<List<Long>> paintings=new ArrayList<>();
        long prev=0;
        long color=0;
        for(Integer curr:map.keySet()){

            if(prev>0 && color>0){
             paintings.add(List.of(prev,(long)curr,color));
            }

            color+=map.get(curr);
            prev=curr;
        }

        return paintings;
    }

    public static void main(String[] args) {
        int s[][]={{1,4,3},{1,7,4},{2,5,2}};
        System.out.println(splitPainting(s));
        //[[1,2,7],[2,4,9],[4,5,6],[5,7,4]]
        /*
        (1,7)
        (2,
         */

    }
}
