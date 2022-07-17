/*
import java.util.Comparator;
import java.util.PriorityQueue;

class Pair {

  Integer index;
  Integer end;

   Pair(int index,int end){
       this.index=index;
      this.end=end;
   }

}
public class SingleThreadedCPU {



    public  static int[] getOrder(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0];
        }
        PriorityQueue<Pair> allocator =
                new PriorityQueue<Pair>(
                        intervals.length,
                        new Comparator<Pair>() {
                            public int compare(Pair a , Pair b) {
                                if(a.end==b.end){
                                    return  a.index-b.index;
                                }
                                else {
                                    return a.end - b.end;
                                }
                            }
                        });
        allocator.add(new Pair(0,intervals[0][1]));
        int currentCapacity=intervals[0][0];
        for(int i=1;i<intervals.length;i++) {
            allocator.add(new Pair(i, intervals[i][1]));
        }

        int arr[]=new int[intervals.length];
        int i=0;
        while(!allocator.isEmpty()){
            arr[i++]=allocator.poll().index;
        }
        return arr;
    }

    public static void main(String[] args) {
        int pairs[][]={{1,2},{2,4},{3,2},{4,1}};

        getOrder(pairs);
    }
}
*/
