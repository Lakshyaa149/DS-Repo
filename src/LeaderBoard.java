/*
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class LeaderBoard {

    HashMap<Integer,Integer> hashMap;
    public Leaderboard() {
    hashMap=new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        this.hashMap.put(playerId,this.hashMap.getOrDefault(playerId,0)+score);
    }

    public int top(int K) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(Integer val:hashMap.values()){
            priorityQueue.offer(val);
            if(priorityQueue.size()>K){
                priorityQueue.poll();
            }
        }
        int total=0;

        while(!priorityQueue.isEmpty()){
            total+=priorityQueue.poll();
        }

     return total;
    }

    public void reset(int playerId) {

        this.hashMap.put(playerId,0);
    }
}


*/
