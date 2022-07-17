import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Word{
    String content;
    int count;

    Word(String content,int count){
        this.content=content;
        this.count=count;
    }
}
public class KMaxFreqWords {


    public static List<String> topKFrequent(String[] words, int k) {


        HashMap<String,Integer> map=new HashMap<>();

        for(int i=0;i<words.length;i++){

            if(!map.containsKey(words[i])){
                map.put(words[i],1);
            }
            else{
                int c=map.get(words[i]);
                map.put(words[i],c+1);
            }
        }

        PriorityQueue<Word> priorityQueue=new PriorityQueue<>(new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if(o1.count==o2.count){
                 return o2.content.compareTo(o1.content);
               }
                return o2.count-o1.count;

            }
        });

        for(Map.Entry<String,Integer> entry:map.entrySet()){

            priorityQueue.add(new Word(entry.getKey(),entry.getValue()));

        }

        List<String> list=new ArrayList<>();
        for(int i=0;i<k;i++){
           list.add(priorityQueue.poll().content);
        }
     return list;
    }

    public static void main(String[] args) {

        String words[]={"i","love","leetcode","i","love","coding"};

        int k=2;
        System.out.println(topKFrequent(words,k));



    }
}
