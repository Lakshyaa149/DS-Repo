import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Interval implements Comparator<Interval> {

    int start;
    int end;
    @Override
    public int compare(Interval o1, Interval o2) {
        return o2.end-o1.end;
    }
}
public class MeetingRooms {

    public int minMeetingRooms(int[][] intervals) {


        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });


        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(final int[] a, final int[] b) {
                        return a[0] - b[0];
                    }
                });


        allocator.add(intervals[0][1]);


        for(int i=1;i<intervals.length;i++){


            if(allocator.peek()<=intervals[i][0]){
                allocator.poll();
            }
            allocator.add(intervals[i][1]);


        }
       return allocator.size();
    }
}
