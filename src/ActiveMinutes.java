import java.util.HashMap;
import java.util.HashSet;

public class ActiveMinutes {

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        HashMap<Integer, HashSet<Long>> map = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap();

        for (int i = 0; i < logs.length; i++) {

            int time = logs[i][0];
            int personId = logs[i][1];
            HashSet<Long> set=null;
            if (map.containsKey(time)) {
                 set = map.get(time);
            } else {
                 set = new HashSet<>();
            }
            if (set.add((long) personId)) {
                if (count.containsKey(personId)) {
                    long  c = count.get(personId);
                    c += 1;
                    count.put(personId, (int)c);
                } else {
                    count.put(personId, 1);
                }
            }
            map.put(time, set);

        }

        int arr[] = new int[1000001];

        for (Integer v : count.values()) {
            arr[v]++;
        }

        int ans[] = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            ans[i] = arr[i - 1];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
