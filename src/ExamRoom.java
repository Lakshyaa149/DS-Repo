import java.util.ArrayList;
import java.util.List;

public class ExamRoom {
    int n;
        List<Integer> list;
        public ExamRoom(int n) {
            this.n = n;
            list = new ArrayList<>();
        }

        public int seat() {
            if (list.isEmpty()) {
                list.add(0);
                return 0;
            }

            // get max distance of [left edge <-> 1st element] and [last element <-> right edge]
            int distance = Math.max(list.get(0) - 0, n - 1 - list.get(list.size()-1));
            for (int i = 0; i < list.size()-1; i++) {
                // find the biggest distance in the middle
                distance = Math.max(distance, (list.get(i+1) - list.get(i)) / 2);
            }

            if (list.get(0) == distance) { // for instance, list = [9]
                list.add(0, 0);
                return 0;
            }

            // find the range that contribute the largest distance and add the index
            for (int i = 0; i < list.size()-1; i++) {
                if ((list.get(i+1) - list.get(i)) / 2 == distance) {
                    list.add(i+1, (list.get(i) + list.get(i+1)) / 2);
                    return list.get(i+1);
                }
            }

            list.add(n-1);
            return n-1;
        }

        public void leave(int p) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == p) {
                    list.remove(i);
                }
            }
        }

    public static void main(String[] args) {

            ExamRoom examRoom=new ExamRoom(10);

            examRoom.seat();
            examRoom.seat();
            /*examRoom.seat();
            examRoom.seat();
            examRoom.seat();*/
            examRoom.leave(0);
            examRoom.seat();





    }
}

