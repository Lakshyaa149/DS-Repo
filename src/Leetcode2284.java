import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class PersonWordCount{

    String name;
    int count;

    public PersonWordCount(String key, Integer value) {
        this.name=key;
        this.count=value;
    }
}

public class Leetcode2284 {


    public String largestWordCount(String[] messages, String[] senders) {

        int n=messages.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            String  arr[]=messages[i].split(" ");
            if(map.containsKey(senders[i])){
                int count=map.get(senders[i]);
                count+=arr.length;
            }
            else{
                map.put(senders[i],arr.length);
            }

        }

        PriorityQueue<PersonWordCount> priorityQueue=new PriorityQueue<>(new Comparator<PersonWordCount>() {
            @Override
            public int compare(PersonWordCount o1, PersonWordCount o2) {
                if(o1.count==o2.count){
                    return o1.name.compareTo(o2.name);
                }
                return o2.count-o1.count;
            }
        });


        for(Map.Entry<String,Integer> entry:map.entrySet()){

            priorityQueue.add(new PersonWordCount(entry.getKey(),entry.getValue()));

        }

        return priorityQueue.poll().name;

    }
}
